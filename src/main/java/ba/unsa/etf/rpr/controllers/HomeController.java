package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class HomeController {
    public MenuItem buttonMovies;
    public MenuItem buttonMyMovies;
    public MenuButton menu;

    public void showMovies(ActionEvent actionEvent) throws IOException {
        Stage stage1=(Stage) menu.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        Parent root = fxmlloader.load();
        stage1.setTitle("Movie");
        //  stage.getIcons().add(new Image("/src/main/resources/img/download"));
        stage1.setScene(new Scene(root,500,500));
        stage1.show();
    }

    public void showMyMovies(ActionEvent actionEvent) {
    }

    public void showHome(ActionEvent actionEvent) {
    }
}
