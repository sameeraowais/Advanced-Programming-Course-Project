
package carethy_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.stage.Stage;

public class mediaE1Controler {
     @FXML
   private MediaPlayer E1V1,E1V2,E1V3 ;
     @FXML
    private Tab TE1V1,TE1V2,TE1V3 ;
    @FXML
    private Button back;
     @FXML
    private TabPane tabpanee;
    User user1;   

   public void infor(User user){
       user1=user;  
       mediaE1();
   }
   @FXML
   void back(ActionEvent event) {
 try {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDaysCompleted.fxml"));
        Stage stage = (Stage) back.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        FXMLDaysCompletedController controll = loader.getController();
        controll.infor(user1);
        stage.setTitle("Exercises");
        stage.setScene(scene);
    }catch (IOException io){
    }
    }
   @FXML
    void mediaE1() {         
   if(   null != user1.getTypeofexer())
       switch (user1.getTypeofexer()) {
             case "Legs":
                 tabpanee.getSelectionModel().select(TE1V1);
                 break;
             case "Sixpack":
                 tabpanee.getSelectionModel().select(TE1V2);
                 break;
             case "Full Body":
                 tabpanee.getSelectionModel().select(TE1V3);
                 break;
             default:
                 break;
         }
}
    @FXML
    void E1stopbutton(ActionEvent event) {
        E1V1.stop();
        E1V2.stop();
        E1V3.stop(); 
    }
     @FXML
    void E1playbutton(ActionEvent event) {
    if(  null != user1.getTypeofexer())
        switch (user1.getTypeofexer()) {
             case "Legs":
                 if(E1V1.getStatus()== PLAYING){
                     E1V1.stop();
                     E1V1.play();
                 }else{
                     E1V1.play();
                  }
                 break;
             case "Sixpack":
                 if(E1V2.getStatus()== PLAYING){
                     E1V2.stop();
                     E1V2.play();
                 }else{
                     E1V2.play();}
                 break;
             case "Full Body":
                 if(E1V3.getStatus()== PLAYING){
                     E1V3.stop();  
                     E1V3.play();
                 }else{
                     E1V3.play();}
                 break;
             default:
                 break;
         }  
    }
}