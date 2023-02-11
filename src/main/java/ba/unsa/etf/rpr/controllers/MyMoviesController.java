package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class MyMoviesController {
    public TableView myMoviesTable;
    private void switchScene(String fxml) throws IOException {
        Stage stage=(Stage) myMoviesTable.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/"+fxml+".fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Home");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
    }

    public void showHome(ActionEvent actionEvent) throws IOException {
        switchScene("home");
    }

    public void showMovies(ActionEvent actionEvent) throws IOException {
        switchScene("movies");
    }
}
