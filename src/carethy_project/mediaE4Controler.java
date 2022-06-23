
package carethy_project;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import static javafx.scene.media.MediaPlayer.Status.PLAYING;
import javafx.stage.Stage;

public class mediaE4Controler {
     @FXML
   private MediaPlayer E4V1,E4V2,E4V3;
     @FXML
    private Tab TE4V1,TE4V2,TE4V3;
     @FXML
    private Button back;
     @FXML
    private TabPane tabpanee;
    User user1;   

   public void infor(User user){
       user1=user;  
       mediaE4();
   }
   @FXML
   void back(MouseEvent event) {
 try {
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDaysCompleted.fxml"));
        Stage stage = (Stage) back.getScene().getWindow();
        Scene scene = new Scene(loader.load());
        FXMLDaysCompletedController controll = loader.getController();
        controll.infor(user1);
        stage.setTitle("Exercises");
        stage.setScene(scene);
    }catch (IOException io){
        io.printStackTrace();
    }
    }
    @FXML
     void mediaE4() {         
   if(   null != user1.getTypeofexer())
       switch (user1.getTypeofexer()) {
             case "Legs":
                 tabpanee.getSelectionModel().select(TE4V1);
                 break;
             case "Sixpack":
                 tabpanee.getSelectionModel().select(TE4V2);
                 break;
             case "Full Body":
                 tabpanee.getSelectionModel().select(TE4V3);
                 break;
             default:
                 break;
         }
}
         @FXML
    void E4stopbutton(ActionEvent event) {
        E4V1.stop();
        E4V2.stop();
        E4V3.stop();
    }
     @FXML
    void E4playbutton(ActionEvent event) {
    if(  null != user1.getTypeofexer())
        switch (user1.getTypeofexer()) {
             case "Legs":
                 if(E4V1.getStatus()== PLAYING){
                     E4V1.stop();
                     E4V1.play();
                 }else{
                     E4V1.play();}
                 break;
             case "Sixpack":
                 if(E4V2.getStatus()== PLAYING){
                     E4V2.stop();
                     E4V2.play();
                 }else{
                     E4V2.play();}
                 break;
             case "Full Body":
                 if(E4V3.getStatus()== PLAYING){
                     E4V3.stop();  
                     E4V3.play();
                 }else{
                     E4V3.play();}
                 break;
             default:
                 break;
         }  
    }
}
