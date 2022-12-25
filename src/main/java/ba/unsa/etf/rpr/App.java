package ba.unsa.etf.rpr;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.util.Objects;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Hello world!
 *
 */
public class App extends Application {
    public static void main(String[] args) {
    launch();
    }
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/sample.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Hello World");
      //  stage.getIcons().add(new Image("/img/download"));
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }
}

