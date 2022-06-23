
package carethy_project;

import java.io.IOException;
import javafx.scene.control.RadioButton;
import org.hibernate.Session;
import org.hibernate.Transaction;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.Window;

public class FXMLHeightWeightController  {
   Session session = HibernateUtil.getSessionFactory().openSession();
    @FXML
    private RadioButton buttonweightkg;
    @FXML
    private RadioButton buttonweightlb;
    @FXML
    private RadioButton buttonheightft;
    @FXML
    private RadioButton buttonheightm;
    @FXML
    private Button buttonstart;
    @FXML
    private TextField textweigth;
    @FXML
    private TextField textheight;
   
    User user1;
     public void infor(User user){
       user1=user;
   }
    @FXML
protected void buttonstartA(ActionEvent event) throws IOException {
       if(wh()){
       FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("FXMLTypeofexer.fxml"));
       Parent root = loader.load();
        FXMLTypeofexerController controller = loader.getController();
        controller.infor(user1);
        Scene personal_info_scene = new Scene(root);
        Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        personal_info_stage.setTitle("Type Of Exercise");
        personal_info_stage.setScene(personal_info_scene);
        personal_info_stage.show(); 
       }
}
@FXML
public void keyPressed(KeyEvent event) throws IOException{                                         
if (event.getCode().equals(KeyCode.ENTER)){
       if(wh()){
        FXMLLoader loader = new FXMLLoader();
       loader.setLocation(getClass().getResource("FXMLTypeofexer.fxml"));
       Parent root = loader.load();
       FXMLTypeofexerController controller = loader.getController();
        controller.infor(user1);
        Scene personal_info_scene = new Scene(root);
        Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        personal_info_stage.setTitle("Type Of Exercise");
        personal_info_stage.setScene(personal_info_scene);
        personal_info_stage.show(); }
}}
@FXML
public boolean wh(){
     Window owner = buttonstart.getScene().getWindow();
   if(textweigth.getText().isEmpty()&&textheight.getText().isEmpty()) {
              showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "Please Enter your Weight and Height");
         return false; }
    if(textweigth.getText().isEmpty()) {
              showAlert(Alert.AlertType.ERROR,owner,"Form Error!", "Please Enter your Weight");
         return false; }
    if(textheight.getText().isEmpty()) {
              showAlert(Alert.AlertType.ERROR, owner,"Form Error!", "Please Enter your Height");
         return false; }
double tempw=Double.parseDouble(textweigth.getText());
double temph=Double.parseDouble(textheight.getText());
user1.setWeight(tempw);
user1.setHeight(temph);
    if(buttonweightkg.isSelected()) {
           user1.setWeightunit("kg");
    }
    else if(buttonweightlb.isSelected()) {
           user1.setWeightunit("lb");
    }
    if(buttonheightm.isSelected()) {
           user1.setHeightunit("m");
    }
    else if(buttonheightft.isSelected()) {
           user1.setHeightunit("ft");
    }
   
        Transaction tx = session.beginTransaction();
        session.update(user1);
        tx.commit();
        return true;
}
public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
Alert alert = new Alert(alertType);
alert.getDialogPane().setPrefSize(280,100);
alert.setResizable(true);
alert.setTitle(title);
alert.setHeaderText(null);
alert.setContentText(message);
alert.initOwner(owner);
alert.show();
}
}