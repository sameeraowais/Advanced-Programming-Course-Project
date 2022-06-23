
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

public class mediaE3Controler {
     @FXML
   private MediaPlayer E3V1,E3V2,E3V3;
     @FXML
    private Tab TE3V1,TE3V2,TE3V3 ;
    @FXML
    private Button back;
     @FXML
    private TabPane tabpanee;
    User user1;   

   public void infor(User user){
       user1=user;  
       mediaE3();
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
        io.printStackTrace();
    }
    }
 
    @FXML
     void mediaE3() {         
   if(   null != user1.getTypeofexer())
       switch (user1.getTypeofexer()) {
             case "Legs":
                 tabpanee.getSelectionModel().select(TE3V1);
                 break;
             case "Sixpack":
                 tabpanee.getSelectionModel().select(TE3V2);
                 break;
             case "Full Body":
                 tabpanee.getSelectionModel().select(TE3V3);
                 break;
             default:
                 break;
         }
}
        @FXML
    void E3stopbutton(ActionEvent event) {
        E3V1.stop();
        E3V2.stop();
        E3V3.stop();
    }
     @FXML
    void E3playbutton(ActionEvent event) {
    if(  null != user1.getTypeofexer())
        switch (user1.getTypeofexer()) {
             case "Legs":
                 if(E3V1.getStatus()== PLAYING){
                     E3V1.stop();
                     E3V1.play();
                    System.out.println("3333");

                 }else{
                     E3V1.play();}
                 break;
             case "Sixpack":
                 if(E3V2.getStatus()== PLAYING){
                     E3V2.stop();
                     E3V2.play();
                 }else{
                     E3V2.play();}
                 break;
             case "Full Body":
                 if(E3V3.getStatus()== PLAYING){
                     E3V3.stop();  
                     E3V3.play();
                 }else{
                     E3V3.play();}
                 break;
             default:
                 break;
         }  
    }
    
}