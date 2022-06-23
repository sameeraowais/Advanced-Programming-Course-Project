
package carethy_project;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class FXMLTypeofexerController implements Initializable {

    User user1;
     public void infor(User user){
       user1=user;
   }
@Override
public void initialize(URL url, ResourceBundle rb) {
}
@FXML
private void Legs(ActionEvent event) throws IOException {
user1.setTypeofexer("Legs");

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
private void Sixpack(ActionEvent event) throws IOException {
user1.setTypeofexer("Sixpack");
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
private void FullBody(ActionEvent event) throws IOException {
user1.setTypeofexer("Full Body");
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
 
}