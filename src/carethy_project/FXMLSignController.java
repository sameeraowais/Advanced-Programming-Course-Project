
package carethy_project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FXMLSignController  {
Session session = HibernateUtil.getSessionFactory().openSession();
@FXML
private HBox hbox_signin;

 @FXML
private HBox hbox_signup;
@FXML
private AnchorPane pane_signup;

 @FXML
private TextField text_username;

 @FXML
private PasswordField text_password;

 @FXML
private TextField text_email;

 @FXML
private Button btn_signup;

 @FXML
private AnchorPane pane_signin;

 @FXML
private TextField text_username1;

 @FXML
private PasswordField text_password1;

 @FXML
private Button btn_signin;

 @FXML
private CheckBox checkbox;

 //-----------------------------------------------------------------------
@FXML
private void SigninPaneShow(ActionEvent event) throws IOException {
pane_signin.setVisible(true);
pane_signup.setVisible(false);
hbox_signin.setVisible(true);
hbox_signup.setVisible(false);
}
@FXML
private void SignupPaneShow(ActionEvent event) throws IOException {

pane_signin.setVisible(false);
pane_signup.setVisible(true);
hbox_signin.setVisible(false);
hbox_signup.setVisible(true);
}

 //-------------------------------------------------------------------


@FXML
private void handleSigninAction(ActionEvent event) throws IOException, SQLException {
Window owner = btn_signin.getScene().getWindow();
if(text_username1.getText().equals("") && text_password1.getText().equals(""))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your name and password");
return;
}
else if(text_username1.getText().equals("") && !text_password1.getText().equals(""))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your name");
return;
}
else if(text_password1.getText().equals("") && !text_username1.getText().equals(""))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your password");
return;
}
else{
session = HibernateUtil.getSessionFactory().openSession();
List<User> uList = null;
String queryStr = "from User";
Query query = session.createQuery(queryStr);
uList = query.list();
session.close();
int count=0;

for(User u : uList)
{
if (u.getUsername().contains(text_username1.getText()) && u.getPassword().equals(text_password1.getText()))
{
showAlert(Alert.AlertType.CONFIRMATION, owner, "From Carethy","Welcome " + text_username1.getText());
System.out.println("the count = " + count);
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLHomePage.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLHomePageController controll = loader.getController();
controll.infor(u);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("Home Page");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();

return;
}

count++;
}
if(count == uList.size()){
showAlert(Alert.AlertType.CONFIRMATION, owner, "Error!","You entered the wrong information" );
System.out.println("the count = " + count);
return;
}
}
}

 //-------------------------------------------------------------------
public static boolean isValid(String email)
{
String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
"[a-zA-Z0-9_+&*-]+)*@" +
"(?:[a-zA-Z0-9-]+\\.)+[a-z" +
"A-Z]{2,7}$";
Pattern pat = Pattern.compile(emailRegex);
if (email == null)
return false;
return pat.matcher(email).matches();
}
@FXML
public void register(ActionEvent event) throws SQLException, IOException {

 Window owner = btn_signup.getScene().getWindow();

if (text_username.getText().isEmpty() && text_email.getText().isEmpty() && text_password.getText().isEmpty()) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please complete the form");
return;
}
else if (!text_username.getText().isEmpty() && text_email.getText().isEmpty() &&  text_password.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your email and password");
        return;
        }
       
        else if (text_username.getText().isEmpty() && !text_email.getText().isEmpty() &&  text_password.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your username and password");
        return;
        }
         
        else if (text_username.getText().isEmpty() && text_email.getText().isEmpty() &&  !text_password.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your username and email");
        return;
        }
else if (text_username.getText().isEmpty()) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your name");
return;
}

 else if (text_email.getText().isEmpty()) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your email");
return;
}

 else{
if (text_password.getText().length() < 10) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "The password is too shore, should be at least 10 digits");
return;
}
else{
if (!isValid(text_email.getText()))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "The email is invalid");
return;
}
else{
session = HibernateUtil.getSessionFactory().openSession();
List<User> uList = null;
String queryStr = "from User";
Query query = session.createQuery(queryStr);
uList = query.list();
session.close();
int count=0;

for(User u : uList)
{
if (text_username.getText().equals(u.getUsername()))
{
showAlert(Alert.AlertType.CONFIRMATION, owner, "Error!","The username already exists");
System.out.println("the count = " + count);
return;
}
count++;
}
if(count == uList.size()){
User user = new User();
user.setUsername(text_username.getText());
user.setEmail(text_email.getText());
user.setPassword(text_password.getText());
session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

 session.save(user);
tx.commit();
session.close();
showAlert(Alert.AlertType.CONFIRMATION, owner, "From Carethy","Welcome " + text_username.getText());
System.out.println("the count = " + count);

FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLHeightWeight.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLHeightWeightController controll = loader.getController();
controll.infor(user);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("Height and Weight");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();
return;
}
}
}
}
} //end action
@FXML
public void keyPressedSignin(KeyEvent event) throws IOException, SQLException{
Window owner = btn_signin.getScene().getWindow();
if (event.getCode().equals(KeyCode.ENTER)){
if(text_username1.getText().equals("") && text_password1.getText().equals(""))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your name and password");
return;
}
else if(text_username1.getText().equals("") && !text_password1.getText().equals(""))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your name");
return;
}
else if(text_password1.getText().equals("") && !text_username1.getText().equals(""))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your password");
return;
}
else{
session = HibernateUtil.getSessionFactory().openSession();
List<User> uList = null;
String queryStr = "from User";
Query query = session.createQuery(queryStr);
uList = query.list();
session.close();
int count=0;

for(User u : uList)
{
if (u.getUsername().contains(text_username1.getText()) && u.getPassword().equals(text_password1.getText()))
{
showAlert(Alert.AlertType.CONFIRMATION, owner, "From Carethy","Welcome " + text_username1.getText());
System.out.println("the count = " + count);
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLHomePage.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLHomePageController controll = loader.getController();
controll.infor(u);

Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("Home Page");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();
return;
}

count++;
}
if(count == uList.size()){
showAlert(Alert.AlertType.CONFIRMATION, owner, "Error!","You entered the wrong information" );
System.out.println("the count = " + count);
return;
}
}
}}
@FXML
public void keyPressedSignup(KeyEvent event) throws IOException, SQLException{
Window owner = btn_signup.getScene().getWindow();
if (event.getCode().equals(KeyCode.ENTER)){
if (text_username.getText().isEmpty() && text_email.getText().isEmpty() && text_password.getText().isEmpty()) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please complete the form");
return;
}
else if (!text_username.getText().isEmpty() && text_email.getText().isEmpty() &&  text_password.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your email and password");
        return;
        }
       
        else if (text_username.getText().isEmpty() && !text_email.getText().isEmpty() &&  text_password.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your username and password");
        return;
        }
         
        else if (text_username.getText().isEmpty() && text_email.getText().isEmpty() &&  !text_password.getText().isEmpty()) {
        showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your username and email");
        return;
        }
else if (text_username.getText().isEmpty()) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your name");
return;
}

 else if (text_email.getText().isEmpty()) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "Please enter your email");
return;
}

 else{
if (text_password.getText().length() < 10) {
showAlert(Alert.AlertType.ERROR, owner, "Error!", "The password is too shore, should be at least 10 digits");
return;
}
else{
if (!isValid(text_email.getText()))
{
showAlert(Alert.AlertType.ERROR, owner, "Error!", "The email is invalid");
return;
}
else{
session = HibernateUtil.getSessionFactory().openSession();
List<User> uList = null;
String queryStr = "from User";
Query query = session.createQuery(queryStr);
uList = query.list();
session.close();
int count=0;

for(User u : uList)
{
if (text_username.getText().equals(u.getUsername()))
{
showAlert(Alert.AlertType.CONFIRMATION, owner, "Error!","The username already exists");
System.out.println("the count = " + count);
return;
}
count++;
}
if(count == uList.size()){
User user = new User();
user.setUsername(text_username.getText());
user.setEmail(text_email.getText());
user.setPassword(text_password.getText());
session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();

session.save(user);
tx.commit();
session.close();
showAlert(Alert.AlertType.CONFIRMATION, owner, "From Carethy","Welcome " + text_username.getText());
System.out.println("the count = " + count);

FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLHeightWeight.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLHeightWeightController controll = loader.getController();
controll.infor(user);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("Height and Weight");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();
return;
}
}}}}
}
 private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
Alert alert = new Alert(alertType);
alert.setTitle(title);
alert.getDialogPane().setPrefSize(280,100);
alert.setResizable(true);
alert.setHeaderText(null);
alert.setContentText(message);
alert.initOwner(owner);
alert.show();
}
}