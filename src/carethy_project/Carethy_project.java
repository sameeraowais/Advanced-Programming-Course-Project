
package carethy_project;

import java.sql.SQLException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Carethy_project extends Application {
    @Override
    public void start(Stage stage) throws Exception {
      
        Parent AnchorPane = FXMLLoader.load(getClass().getResource("FXMLLogo.fxml"));
        stage.setTitle("Carethy");
        Scene scene = new Scene(AnchorPane);  
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) throws SQLException {
        launch(args);
    }
}
