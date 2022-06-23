
package carethy_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FXMLDaysCompletedController {
    
     Session session = HibernateUtil.getSessionFactory().openSession();
    @FXML
    private Tab Sun;
    @FXML
    private Tab Mon;
    @FXML
    private Tab Tues;
    @FXML
    private Tab Wed;
    @FXML
    private Tab Thurs;
    @FXML
    private Tab Fri;
    @FXML
    private Tab Sat;
    @FXML
    private CheckBox check1,check2,check3,check4,checkM1,checkM2,checkM3,checkM4,
            checkt1,checkt2,checkt3,checkt4,checkw1,checkw2,checkw3,checkw4,
            checkth1,checkth2,checkth3,checkth4,checkf1,checkf2,checkf3,checkf4,
            checks1,checks2,checks3,checks4;
    @FXML
    private Button buttonn1;
    @FXML
    private TabPane tabpane;
    User user1;   
    int day;
      @FXML

public void infor(User user){
user1=user; 

     switch (user1.getChallenge()) {
          case "just1weeks":
              day=7;
              break;
          case "just2weeks":
              day=14;
              break;
          case "just3weeks":
              day=21;
              break;
          case "month":
              day=28;
              break;
          default:
              break;
      }
if(user1.getDayscompleted()==0){
Sun.setDisable(false);
user1.setDays("null");
}
switch(user1.getDays()){
case "Sun":
Mon.setDisable(false);
tabpane.getSelectionModel().select(Mon);
break;
case "Mon":
Tues.setDisable(false);
tabpane.getSelectionModel().select(Tues);
break;
case "Tues":
Wed.setDisable(false);
tabpane.getSelectionModel().select(Wed);
break;
case "Wed":
Thurs.setDisable(false);
tabpane.getSelectionModel().select(Thurs);
break;
case "Thurs":
Fri.setDisable(false);
tabpane.getSelectionModel().select(Fri);
break;
case "Fri":
Sat.setDisable(false);
tabpane.getSelectionModel().select(Sat);
break;
case "Sat":
Sun.setDisable(false);
tabpane.getSelectionModel().select(Sun);
break;
default:
Sun.setDisable(false);
tabpane.getSelectionModel().select(Sun);
break;
}

}
@FXML
protected void nextTabpane(Event event) throws IOException {
if(user1.getDayscompleted()!=day){
if(check1.isSelected()&&check2.isSelected()&&check3.isSelected()&&check4.isSelected()){
user1.setDays("Sun");
add();
Mon.setDisable(false);
Sun.setDisable(true);
tabpane.getSelectionModel().select(Mon);
alert();
check1.setSelected(false);
check2.setSelected(false);
check3.setSelected(false);
check4.setSelected(false);
}else if(checkM1.isSelected()&&checkM2.isSelected()&&checkM3.isSelected()&&checkM4.isSelected()){
user1.setDays("Mon");
add();
Tues.setDisable(false);
Mon.setDisable(true);
tabpane.getSelectionModel().select(Tues);
alert();
checkM1.setSelected(false);
checkM2.setSelected(false);
checkM3.setSelected(false);
checkM4.setSelected(false);
} else if(checkt1.isSelected()&&checkt2.isSelected()&&checkt3.isSelected()&&checkt4.isSelected()){
user1.setDays("Tues");
    add();
Wed.setDisable(false);
Tues.setDisable(true);
tabpane.getSelectionModel().select(Wed);
alert();
checkt1.setSelected(false);
checkt2.setSelected(false);
checkt3.setSelected(false);
checkt4.setSelected(false);
}else if(checkw1.isSelected()&&checkw2.isSelected()&&checkw3.isSelected()&&checkw4.isSelected()){
user1.setDays("Wed");
add();
Thurs.setDisable(false);
Wed.setDisable(true);
tabpane.getSelectionModel().select(Thurs);
alert();
checkw1.setSelected(false);
checkw2.setSelected(false);
checkw3.setSelected(false);
checkw4.setSelected(false);
}else if(checkth1.isSelected()&&checkth2.isSelected()&&checkth3.isSelected()&&checkth4.isSelected()){
user1.setDays("Thurs");
    add();
Fri.setDisable(false);
Thurs.setDisable(true);
tabpane.getSelectionModel().select(Fri);
alert();
checkth1.setSelected(false);
checkth2.setSelected(false);
checkth3.setSelected(false);
checkth4.setSelected(false);
}else if(checkf1.isSelected()&&checkf2.isSelected()&&checkf3.isSelected()&&checkf4.isSelected()){
user1.setDays("Fri");
    add();
Sat.setDisable(false);
Fri.setDisable(true);
tabpane.getSelectionModel().select(Sat);
alert();
checkf1.setSelected(false);
checkf2.setSelected(false);
checkf3.setSelected(false);
checkf4.setSelected(false);
}else if(checks1.isSelected()&&checks2.isSelected()&&checks3.isSelected()&&checks4.isSelected()){
user1.setDays("Sat");
add();
Sun.setDisable(false);
Sat.setDisable(true);
alert();
checks1.setSelected(false);
checks2.setSelected(false);
checks3.setSelected(false);
checks4.setSelected(false);
if(user1.getDayscompleted()==day || user1.getChallenge().equals("just1weeks")){
tabpane.getSelectionModel().select(Sun);

        }else if(user1.getChallenge().equals("just2weeks")){ 
            
try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML2Weeks.fxml"));
Stage stage = (Stage) buttonn1.getScene().getWindow();
Scene scene = new Scene(loader.load());

FXML2WeeksController controll = loader.getController();
controll.infor(user1);
stage.setTitle("Two Weeks Challenge");
stage.setScene(scene);
}catch (IOException io){
io.printStackTrace();
}
        }
         else if(user1.getChallenge().equals("just3weeks")){ 
                   
try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML3Weeks.fxml"));
Stage stage = (Stage) buttonn1.getScene().getWindow();
Scene scene = new Scene(loader.load());

FXML3WeeksController controll = loader.getController();
controll.infor(user1);
stage.setTitle("Three Weeks Challenge");
stage.setScene(scene);
}catch (IOException io){
io.printStackTrace();
}
         }
         else if(user1.getChallenge().equals("month")){ // month challenge 
        try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMonth.fxml"));
Stage stage = (Stage) buttonn1.getScene().getWindow();
Scene scene = new Scene(loader.load());

FXMLMonthController controll = loader.getController();
controll.infor(user1);
stage.setTitle("Month Challenge");
stage.setScene(scene);
}catch (IOException io){
io.printStackTrace();
}
         }
       }
       
        } else if(user1.getDayscompleted()==day){
           alert();
       }
}
 public void add() {
  Transaction tx = session.beginTransaction();
  user1.setNumberofexer(user1.getNumberofexer()+4);
  user1.setDayscompleted(user1.getDayscompleted()+1);
  
   if("Legs".equals(user1.getTypeofexer())){
       user1.setCalories(user1.getCalories()+70);
   }
   else if("Sixpack".equals(user1.getTypeofexer())){
        user1.setCalories(user1.getCalories()+70);
   }
   else if("Full Body".equals(user1.getTypeofexer())){
        user1.setCalories(user1.getCalories()+100);
   }
  session.update(user1);
  tx.commit();  
  }
 public void alert() {
   Window owner = buttonn1.getScene().getWindow();
   if(user1.getDayscompleted()==day){
     showAlert(Alert.AlertType.INFORMATION, owner, "Form Carethy", "You Successfully Completed Your Challenge");
   }else{ showAlert(Alert.AlertType.INFORMATION, owner, "Form Carethy", "You Successfully Completed The Day");}
 }
  @FXML
   protected void E1(MouseEvent event) throws IOException {
      FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mE1.fxml"));
        Parent root = loader.load();
        mediaE1Controler controller = loader.getController();
        controller.infor(user1);
        Scene personal_info_scene = new Scene(root);
        Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        personal_info_stage.setTitle("Exercise One");
        personal_info_stage.setScene(personal_info_scene);
        personal_info_stage.show();
   }
    @FXML
   protected void E2(MouseEvent event) throws IOException {
       FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mE2.fxml"));
        Parent root = loader.load();
        mediaE2Controler controller = loader.getController();
       controller.infor(user1);
        Scene personal_info_scene = new Scene(root);
        Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        personal_info_stage.setTitle("Exercise Two");
        personal_info_stage.setScene(personal_info_scene);
        personal_info_stage.show();
   }
    @FXML
   protected void E3(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mE3.fxml"));
        Parent root = loader.load();
        mediaE3Controler controller = loader.getController();
        controller.infor(user1);
        Scene personal_info_scene = new Scene(root);
        Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        personal_info_stage.setTitle("Exercise Three");
        personal_info_stage.setScene(personal_info_scene);
        personal_info_stage.show();
   }
    @FXML
   protected void E4(MouseEvent event) throws IOException {
     FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("mE4.fxml"));
        Parent root = loader.load();
        mediaE4Controler controller = loader.getController();
        controller.infor(user1);
        Scene personal_info_scene = new Scene(root);
        Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        personal_info_stage.setTitle("Exercise Four");
        personal_info_stage.setScene(personal_info_scene);
        personal_info_stage.show();
   }
public static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
Alert alert = new Alert(alertType);
alert.setTitle(title);
alert.getDialogPane().setPrefSize(280,100);
alert.setResizable(true);
alert.setHeaderText(null); 
alert.setContentText(message);
alert.initOwner(owner); 
alert.show();
}

@FXML
private void profile(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLProfile.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLProfileController controller = loader.getController();
controller.infor(user1);
Scene scene = new Scene(root);
Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
stage.setTitle("My Profile");
stage.setScene(scene);
stage.show();
}
@FXML
private void updates(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLUpdates.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLUpdatesController controller = loader.getController();
controller.infor(user1);
Scene scene = new Scene(root);
Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
stage.setTitle("My Report");
stage.setScene(scene);
stage.show();
}

 @FXML
private void exercises(ActionEvent event) throws IOException {
          FXMLLoader loader = new FXMLLoader();
       if(user1.getChallenge()==null){
       loader.setLocation(getClass().getResource("FXMLChallenge.fxml"));
       //getting the scene graph object
       Parent root = loader.load();
        FXMLChallengeController controller = loader.getController();
        controller.infor(user1);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Challenge");
        stage.setScene(scene);
        stage.show(); 
        
       }else if(user1.getChallenge().equalsIgnoreCase("just2weeks"))
       {
       loader.setLocation(getClass().getResource("FXML2Weeks.fxml"));
       //getting the scene graph object
       Parent root = loader.load();
        FXML2WeeksController controller = loader.getController();
        controller.infor(user1);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Weeks of Challenge");
        stage.setScene(scene);
        stage.show(); 

       }else if(user1.getChallenge().equalsIgnoreCase("just3weeks"))
       {
       loader.setLocation(getClass().getResource("FXML3Weeks.fxml"));
       //getting the scene graph object
       Parent root = loader.load();
        FXML3WeeksController  controller = loader.getController();
        controller.infor(user1);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Weeks of Challenge");
        stage.setScene(scene);
        stage.show(); 

       }else if(user1.getChallenge().equalsIgnoreCase("month"))
       {
       loader.setLocation(getClass().getResource("FXMLMonth.fxml"));
       //getting the scene graph object
       Parent root = loader.load();
        FXMLMonthController controller = loader.getController();
        controller.infor(user1);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Weeks of Challenge");
        stage.setScene(scene);
        stage.show(); 

       }else if(user1.getChallenge().equalsIgnoreCase("just1weeks")){
           loader.setLocation(getClass().getResource("FXMLDaysCompleted.fxml"));
       //getting the scene graph object
       Parent root = loader.load();
        FXMLDaysCompletedController controller = loader.getController();
        controller.infor(user1);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Exercises");
        stage.setScene(scene);
        stage.show(); 
    
       }    
}
}