
package carethy_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FXMLHomePageController  {
@FXML
   private Button exe;
 User user1;
public void infor(User user){
user1=user;
}
 @FXML
 void mychallenge(ActionEvent event) throws IOException {
 FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLDaysCompleted.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLDaysCompletedController controll = loader.getController();
controll.infor(user1);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();
}

@FXML
 void newchallenge(ActionEvent event) throws IOException {
user1.setDayscompleted(0);
user1.setCalories(0);
user1.setNumberofexer(0);
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();
FXMLLoader loader = new FXMLLoader();
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
}
 @FXML
 void newexercise(ActionEvent event) throws IOException {
user1.setDayscompleted(0);
user1.setCalories(0);
user1.setNumberofexer(0);
user1.setTypeofexer(null);
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLTypeofexer.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLTypeofexerController controller = loader.getController();
controller.infor(user1);
Scene scene = new Scene(root);
Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
stage.setTitle("Type Of Exercise");
stage.setScene(scene);
stage.show();
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
        stage.setTitle("Weeks Of Challenge");
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
        stage.setTitle("Weeks Of Challenge");
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
        stage.setTitle("Weeks Of Challenge");
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
        stage.setTitle("Exercisee");
        stage.setScene(scene);
        stage.show(); 
    
       }   
}
}
