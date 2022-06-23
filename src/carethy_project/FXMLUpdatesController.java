
package carethy_project;

import java.io.IOException;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import org.hibernate.Session;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;  
import javafx.stage.Stage;

public class FXMLUpdatesController { 
 Session session = HibernateUtil.getSessionFactory().openSession();
    @FXML
    private TextField Cweight;
    @FXML
    private TextField CHeight;
    @FXML
    private Label NExercises;
    @FXML
    private Label NCalories;
    @FXML
    private Label Ndays;
    @FXML
    private Slider slider;
    @FXML
    private CheckBox day1,day2,day3,day4,day5,day6,day7,day8,day9,day10,day11,day12,
            day13,day14,day15,day16,day17,day18,day19,day20
            ,day21,day22,day23,day24,day25,day26,day27,day28; 
    User user1;
    
   public void infor(User user){
       user1=user;
       ControllerPagee2();
   }

@FXML
 void ControllerPagee2() {
String tempn = Integer.toString(user1.getNumberofexer());
   NExercises.setText(tempn);
   String tempc = Integer.toString((int) user1.getCalories());
   NCalories.setText(tempc);
   String tempd = Integer.toString(user1.getDayscompleted());
   Ndays.setText(tempd);
   String tempww=String.valueOf(user1.getWeight());  
   Cweight.setText(tempww);
   String temphh=String.valueOf(user1.getHeight());  
   CHeight.setText(temphh);

   switch(user1.getDayscompleted()){
       case 28:
            day28.setSelected(true);
       case 27:
            day27.setSelected(true);
       case 26:
            day26.setSelected(true);
       case 25:
            day25.setSelected(true);
       case 24:
            day24.setSelected(true);
       case 23:
            day23.setSelected(true);
       case 22:
            day22.setSelected(true);
       case 21:
            day21.setSelected(true);
       case 20:
            day20.setSelected(true);
       case 19:
            day19.setSelected(true);
       case 18:
            day18.setSelected(true);
       case 17:
            day17.setSelected(true);
       case 16:
            day16.setSelected(true);
       case 15:
            day15.setSelected(true);
       case 14:
            day14.setSelected(true);
       case 13:
            day13.setSelected(true);
       case 12:
            day12.setSelected(true);
       case 11:
            day11.setSelected(true);
       case 10:
            day10.setSelected(true);
       case 9:
            day9.setSelected(true);
       case 8:
            day8.setSelected(true);
       case 7:
            day7.setSelected(true);
       case 6:
            day6.setSelected(true);
       case 5:
            day5.setSelected(true);
       case 4:
            day4.setSelected(true);
       case 3:
            day3.setSelected(true);
       case 2:
           day2.setSelected(true);
       case 1:
           day1.setSelected(true);
           break;
   }
   double weighttemp = user1.getWeight();
   double heighttemp = user1.getHeight();
   if(user1.getWeightunit().equals("lb")){
       weighttemp*=2.20;
   }
   if(user1.getHeightunit().equals("ft")){
       heighttemp*=0.0929;
   }
  double calculat = weighttemp/(Math.pow(heighttemp,2));
  
if( calculat >= 40){
    slider.setValue(100); 
}else if( calculat >= 30 && calculat<40){
    slider.setValue(80); 
}else if( calculat >= 25 && calculat<30){
    slider.setValue(65); 
}else if( calculat >=18.5 &&calculat < 25){
    slider.setValue(50);
}else if(  calculat > 16 && calculat <18.5){
    slider.setValue(20);
}
else if( calculat >= 15 && calculat <16){
    slider.setValue(10);
}else if( calculat < 15){
    slider.setValue(0);
}
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