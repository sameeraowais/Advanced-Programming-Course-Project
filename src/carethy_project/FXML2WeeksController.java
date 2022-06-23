
package carethy_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FXML2WeeksController {
     Session session;
   User user1;
           
        public void infor(User user){
       user1 = user;
 }
     
    @FXML
    private Button w2_1;

    @FXML
    private Button w2_2;

    @FXML
    void w2_1(ActionEvent event) throws IOException {
        Window owner = w2_1.getScene().getWindow();
if(user1.getWeeks()==null){
user1.setWeeks("w2_1");
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLDaysCompleted.fxml")); //getting the scene graph object
Parent root = loader.load();
FXMLDaysCompletedController controll = loader.getController();
controll.infor(user1);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("week 1");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();
}
else if(user1.getDayscompleted()>=7){
showAlert(Alert.AlertType.INFORMATION, owner, "Form Carethy", "this week challenge is already done ");
return;
}
else{
   Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLDaysCompleted.fxml")); //getting the scene graph object
Parent root = loader.load();
FXMLDaysCompletedController controll = loader.getController();
controll.infor(user1);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("week 1 challenge");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show(); 
}
}
    @FXML
    void w2_2(ActionEvent event) throws IOException {
        Window owner = w2_2.getScene().getWindow();
         if(user1.getWeeks()==null&&user1.getDayscompleted()<7){
        showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "you need to do week 1 First");  
                 return;    
        }
        else if(user1.getWeeks().equalsIgnoreCase("w2_1")&& user1.getDayscompleted()>=7){
        user1.setWeeks("w2_2");
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user1);
        tx.commit();
        session.close();
        
        FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLDaysCompleted.fxml")); //getting the scene graph object
Parent root = loader.load();
FXMLDaysCompletedController controll = loader.getController();
controll.infor(user1);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("week 2 challenge");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();
        }
       
        else if( user1.getDayscompleted()>=14) {
         showAlert(Alert.AlertType.INFORMATION, owner, "Form Carethy!", "this week challenge is already done ");  
                 return; 
        }
         else if(user1.getDayscompleted()<14 && user1.getWeeks().equalsIgnoreCase("w2_2")){
         Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user1);
        tx.commit();
        session.close();
        
        FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLDaysCompleted.fxml")); //getting the scene graph object
Parent root = loader.load();
FXMLDaysCompletedController controll = loader.getController();
controll.infor(user1);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("week 2 challenge");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();   
        }
         else {
            showAlert(Alert.AlertType.ERROR, owner, "Form Error!", "You have previous weeks need to do first ");  
                 return;
        }
    }
  
   @FXML
private void profile(ActionEvent event) throws IOException {
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLProfile.fxml")); //getting the scene graph object
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
loader.setLocation(getClass().getResource("FXMLUpdates.fxml")); //getting the scene graph object
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
       loader.setLocation(getClass().getResource("FXMLChallenge.fxml")); //getting the scene graph object
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
       loader.setLocation(getClass().getResource("FXML2Weeks.fxml")); //getting the scene graph object
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
       loader.setLocation(getClass().getResource("FXML3Weeks.fxml")); //getting the scene graph object
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
       loader.setLocation(getClass().getResource("FXMLMonth.fxml")); //getting the scene graph object
       Parent root = loader.load();
        FXMLMonthController controller = loader.getController();
        controller.infor(user1);
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Weeks of Challenge");
        stage.setScene(scene);
        stage.show(); 

       }else if(user1.getChallenge().equalsIgnoreCase("just1weeks")){
           loader.setLocation(getClass().getResource("FXMLDaysCompleted.fxml")); //getting the scene graph object
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

}