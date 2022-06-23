
package carethy_project;

import java.io.IOException;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class FXMLProfileController {

     Session session = HibernateUtil.getSessionFactory().openSession();
    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_height;

    @FXML
    private Button btn_save;

    @FXML
    private Label lb_username;

    @FXML
    private Label lb_email;

    @FXML
    private Label lb_password;

    @FXML
    private Button bt_edit;

    @FXML
    private TextField tf_email;

    @FXML
    private TextField tf_weight;

    @FXML
    private Label lb_weight;

    @FXML
    private Label lb_height;
            
    @FXML
    private RadioButton unit_kg;

    @FXML
    private RadioButton unit_lb;

    @FXML
    private RadioButton unit_cm;

    @FXML
    private RadioButton unit_ft;
    
        @FXML
    private Button btn_cancel;
        
    User user1;
    
   public void infor(User user){
       user1=user;
       lb_username.setText(user1.getUsername());
       lb_email.setText(user1.getEmail());
       lb_password.setText(user1.getPassword());
       lb_weight.setText(user1.getWeight()+" "+user1.getWeightunit()) ;
       lb_height.setText(user1.getHeight()+" "+user1.getHeightunit()) ;
       
       tf_email.setText(user1.getEmail());
        tf_password.setText(user1.getPassword());
        String weight=Double.toString(user1.getWeight());
        String height = Double.toString(user1.getHeight());      
        tf_weight.setText(weight);
        tf_height.setText(height);
       
       if(user1.getWeightunit() == "kg")
       unit_kg.setSelected(true);
       else unit_lb.setSelected(true);
       
       if(user1.getHeightunit() == "m")
       unit_cm.setSelected(true);
       else unit_ft.setSelected(true);
   }
      
    @FXML
    private void EditPaneShow(ActionEvent event) throws IOException {

        btn_save.setOpacity(1);
        btn_cancel.setOpacity(1);
        
        tf_email.setOpacity(1);
        tf_password.setOpacity(1);
        tf_height.setOpacity(1);
        tf_weight.setOpacity(1);
        unit_kg.setOpacity(1); 
        unit_lb.setOpacity(1);
        unit_cm.setOpacity(1);
        unit_ft.setOpacity(1);

        lb_email.setOpacity(0);
        lb_password.setOpacity(0);
        lb_height.setOpacity(0);
        lb_weight.setOpacity(0);
        
        bt_edit.setOpacity(0);

        tf_email.setText(user1.getEmail());
        tf_password.setText(user1.getPassword());
        
        String weight=Double.toString(user1.getWeight()); 
        String height = Double.toString(user1.getHeight());       
        tf_weight.setText(weight);
        tf_height.setText(height);                  
    }
    
    @FXML
    private void Cancel(ActionEvent event) throws IOException {

        Window owner = btn_save.getScene().getWindow();
           
        btn_save.setOpacity(0);
        btn_cancel.setOpacity(0);

        tf_email.setOpacity(0);
        tf_password.setOpacity(0);
        tf_height.setOpacity(0);
        tf_weight.setOpacity(0);
        unit_kg.setOpacity(0); 
        unit_lb.setOpacity(0);
        unit_cm.setOpacity(0);
        unit_ft.setOpacity(0);
        
        lb_email.setOpacity(1);
        lb_password.setOpacity(1);
        lb_height.setOpacity(1);
        lb_weight.setOpacity(1);
       
        bt_edit.setOpacity(1);      
    }
    
    
    @FXML
    private void SavePaneShow(ActionEvent event) throws IOException {

        Window owner = btn_save.getScene().getWindow();
          
        
if(tf_email.getText().isEmpty() || tf_password.getText().isEmpty() || tf_weight.getText().isEmpty() || tf_height.getText().isEmpty())       
    { 
        showAlert(Alert.AlertType.CONFIRMATION, owner, "Error!","You have to filled in all fields");
        return; 
    }
else
{ 
    if(unit_cm.isSelected()) {
           user1.setHeightunit("m");
           lb_height.setText(tf_height.getText()+" "+user1.getHeightunit());
    }
    else if(unit_ft.isSelected()) {
           user1.setHeightunit("ft");
          lb_height.setText(tf_height.getText()+" "+user1.getHeightunit());
    }
         
           if(unit_kg.isSelected()) {
           user1.setWeightunit("kg");
           lb_weight.setText(tf_weight.getText()+" "+user1.getWeightunit());
    }
    else if(unit_lb.isSelected()) {
        user1.setWeightunit("lb");
            lb_weight.setText(tf_weight.getText()+" "+user1.getWeightunit());
    }
}
if(tf_email.getText().equals(user1.getEmail()) && tf_password.getText().equals(user1.getPassword()) && tf_weight.getText().equals(user1.getWeight()) && tf_height.getText().equals(user1.getHeight()))
        {
        btn_save.setOpacity(0);
        btn_cancel.setOpacity(0);

        tf_email.setOpacity(0);
        tf_password.setOpacity(0);
        tf_height.setOpacity(0);
        tf_weight.setOpacity(0);
        unit_kg.setOpacity(0); 
        unit_lb.setOpacity(0);
        unit_cm.setOpacity(0);
        unit_ft.setOpacity(0);
        
        lb_email.setOpacity(1);
        lb_password.setOpacity(1);
        lb_height.setOpacity(1);
        lb_weight.setOpacity(1);
       
        bt_edit.setOpacity(1);
        return;
        }

        else{ 

        if(!tf_email.getText().equals(user1.getEmail()))
        { user1.setEmail(tf_email.getText());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user1);
        tx.commit();
        session.close();
        lb_email.setText(tf_email.getText());

 

        btn_save.setOpacity(0);
        btn_cancel.setOpacity(0);

 

        tf_email.setOpacity(0);
        tf_password.setOpacity(0);
        tf_height.setOpacity(0);
        tf_weight.setOpacity(0);
        unit_kg.setOpacity(0); 
        unit_lb.setOpacity(0);
        unit_cm.setOpacity(0);
        unit_ft.setOpacity(0);
        
        lb_email.setOpacity(1);
        lb_password.setOpacity(1);
        lb_height.setOpacity(1);
        lb_weight.setOpacity(1);
       
        bt_edit.setOpacity(1); }
    if(!tf_password.getText().equals(user1.getPassword()))
    {user1.setPassword(tf_password.getText());
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user1);
        tx.commit();
        session.close();
        
        lb_password.setText(tf_password.getText());
        
        btn_save.setOpacity(0);
        btn_cancel.setOpacity(0);

 

        tf_email.setOpacity(0);
        tf_password.setOpacity(0);
        tf_height.setOpacity(0);
        tf_weight.setOpacity(0);
        unit_kg.setOpacity(0); 
        unit_lb.setOpacity(0);
        unit_cm.setOpacity(0);
        unit_ft.setOpacity(0);
        
        lb_email.setOpacity(1);
        lb_password.setOpacity(1);
        lb_height.setOpacity(1);
        lb_weight.setOpacity(1);
       
        bt_edit.setOpacity(1);
 }

     if(!tf_weight.getText().equals(user1.getWeight()))
     {
      
           if(unit_kg.isSelected()) {
           user1.setWeightunit("kg");
    }
    else if(unit_lb.isSelected()) {
           user1.setWeightunit("lb");
    }

 


        
double weight =Double.parseDouble(tf_weight.getText()); 

 

        user1.setWeight(weight);
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user1);
        tx.commit();
        session.close();
        lb_weight.setText(tf_weight.getText()+" "+user1.getWeightunit());
        btn_save.setOpacity(0);
        btn_cancel.setOpacity(0);

 

        tf_email.setOpacity(0);
        tf_password.setOpacity(0);
        tf_height.setOpacity(0);
        tf_weight.setOpacity(0);
        unit_kg.setOpacity(0); 
        unit_lb.setOpacity(0);
        unit_cm.setOpacity(0);
        unit_ft.setOpacity(0);
        
        lb_email.setOpacity(1);
        lb_password.setOpacity(1);
        lb_height.setOpacity(1);
        lb_weight.setOpacity(1);
       
        bt_edit.setOpacity(1);
 }

          if(!tf_height.getText().equals(user1.getHeight()))
     {
if(unit_cm.isSelected()) {
user1.setHeightunit("m");
}
else if(unit_ft.isSelected()) {
user1.setHeightunit("ft");
}

 


        double height =Double.parseDouble(tf_height.getText()); 

 

        user1.setHeight(height);
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.update(user1);
        tx.commit();
        session.close();
        System.out.println("Height has been updated");
        
        lb_height.setText(tf_height.getText()+" "+user1.getHeightunit());
     
        btn_save.setOpacity(0);
        btn_cancel.setOpacity(0);

 

        tf_email.setOpacity(0);
        tf_password.setOpacity(0);
        tf_height.setOpacity(0);
        tf_weight.setOpacity(0);
        unit_kg.setOpacity(0); 
        unit_lb.setOpacity(0);
        unit_cm.setOpacity(0);
        unit_ft.setOpacity(0);
        
        lb_email.setOpacity(1);
        lb_password.setOpacity(1);
        lb_height.setOpacity(1);
        lb_weight.setOpacity(1);
       
        bt_edit.setOpacity(1);
 }
          

 }
 }    
    
@FXML
private void back(ActionEvent event) throws IOException {
   
     
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLHomePage.fxml"));
//getting the scene graph object
Parent root = loader.load();
FXMLHomePageController controll = loader.getController();
controll.infor(user1);
Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("Home Page");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();
   
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
        stage.setTitle("Exercises");
        stage.setScene(scene);
        stage.show(); 
    
       } 
}
        private static void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
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
