
package carethy_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FXMLChallengeController  {
    User user1;
Session session;
@FXML
private Button w1;

 @FXML
private Button w2;

 @FXML
private Button month;

 @FXML
private Button w3;

 public void infor(User user){
user1=user;
}
@FXML
void month(ActionEvent event)throws Exception {

user1.setChallenge("month");
user1.setWeeks(null);
user1.setDayscompleted(0);
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();

try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMonth.fxml"));
Stage stage = (Stage) month.getScene().getWindow();
//getting the scene graph object
Parent root = loader.load();
stage.setScene(new Scene(root));
FXMLMonthController controll = loader.getController();
controll.infor(user1);
stage.setTitle("Month Challenge");

 }catch (IOException io){
io.printStackTrace();

}
}

@FXML
void w1(ActionEvent event)throws Exception {

 user1.setChallenge("just1weeks");
user1.setWeeks(null);
user1.setDayscompleted(0);
Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();

    try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDaysCompleted.fxml"));
Stage stage = (Stage) w1.getScene().getWindow();
Scene scene = new Scene(loader.load());

FXMLDaysCompletedController controll = loader.getController();
controll.infor(user1);
stage.setTitle("One Weeks Challenge");
stage.setScene(scene);
}catch (IOException io){
io.printStackTrace();
}

}

 @FXML
void w2(ActionEvent event) throws Exception {
    
user1.setChallenge("just2weeks"); 
user1.setWeeks(null);
user1.setDayscompleted(0);

 Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();


try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML2Weeks.fxml"));
Stage stage = (Stage) w2.getScene().getWindow();
Scene scene = new Scene(loader.load());

FXML2WeeksController controll = loader.getController();
controll.infor(user1);
stage.setTitle("Two Weeks Challenge");
stage.setScene(scene);
}catch (IOException io){
io.printStackTrace();
}
}
 @FXML
private void w3(ActionEvent event)throws Exception {
     
user1.setChallenge("just3weeks");
user1.setWeeks(null);
user1.setDayscompleted(0);
 Session session = HibernateUtil.getSessionFactory().openSession();
Transaction tx = session.beginTransaction();
session.update(user1);
tx.commit();
session.close();
    try {
FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML3Weeks.fxml"));
Stage stage = (Stage) w3.getScene().getWindow();
Scene scene = new Scene(loader.load());
FXML3WeeksController controll = loader.getController();
controll.infor(user1);
stage.setTitle("Three Weeks Challenge");
stage.setScene(scene);
}catch (IOException io){
io.printStackTrace();
}
}
}