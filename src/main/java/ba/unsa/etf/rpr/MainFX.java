package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * @author Kenan Dizdarevic
 * class for GUI
 */
public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/fxml/login.fxml"));
        stage.setTitle("Online movie rent");
        stage.setResizable(false);
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));

        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
