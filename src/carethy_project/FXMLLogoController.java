
package carethy_project;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.input.MouseEvent;

public class FXMLLogoController {

@FXML
public void click (MouseEvent event) throws IOException
{
FXMLLoader loader = new FXMLLoader();
loader.setLocation(getClass().getResource("FXMLSign.fxml"));
//getting the scene graph object
Parent root = loader.load();

Scene personal_info_scene = new Scene(root);
Stage personal_info_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
personal_info_stage.setTitle("Sign in | Sign up");
personal_info_stage.setScene(personal_info_scene);
personal_info_stage.show();

}
}
