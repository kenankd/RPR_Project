package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MainFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("/resources/login.fxml"));
        stage.setTitle("Hello, World!");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.getScene().getStylesheets().add
                (getClass().getResource("login.css").toExternalForm());
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
