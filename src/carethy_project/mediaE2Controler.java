
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

public class mediaE2Controler {
      @FXML
   private MediaPlayer E2V1,E2V2,E2V3;
     @FXML
    private Tab TE2V1,TE2V2,TE2V3 ;
    @FXML
    private Button back;
     @FXML
    private TabPane tabpanee;
    User user1;   

   public void infor(User user){
       user1=user;  
       mediaE2();
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
     void mediaE2() {         
   if(    null != user1.getTypeofexer())
       switch (user1.getTypeofexer()) {
              case "Legs":
                  tabpanee.getSelectionModel().select(TE2V1);
                  break;
              case "Sixpack":
                  tabpanee.getSelectionModel().select(TE2V2);
                  break;
              case "Full Body":
                  tabpanee.getSelectionModel().select(TE2V3);
                  break;
              default:
                  break;
          }
}
        @FXML
    void E2stopbutton(ActionEvent event) {
        E2V1.stop();
        E2V2.stop();
        E2V3.stop();
    }
     @FXML
    void E2playbutton(ActionEvent event) {
    if(   null != user1.getTypeofexer())
        switch (user1.getTypeofexer()) {
              case "Legs":
                  if(E2V1.getStatus()== PLAYING){
                      E2V1.stop();
                      E2V1.play();
                  }else{
                      E2V1.play();}
                  break;
              case "Sixpack":
                  if(E2V2.getStatus()== PLAYING){
                      E2V2.stop();
                      E2V2.play();
                  }else{
                      E2V2.play();}
                  break;
              case "Full Body":
                  if(E2V3.getStatus()== PLAYING){
                      E2V3.stop();  
                      E2V3.play();
                  }else{
                      E2V3.play();}
                  break;
              default:
                  break;
          }  
    }

}