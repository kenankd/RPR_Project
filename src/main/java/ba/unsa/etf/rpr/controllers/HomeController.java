package ba.unsa.etf.rpr.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * @author Kenan Dizdarevic
 * Controller class which controls everything behind the home display of the app
 */
public class HomeController{
    public MenuItem buttonMovies;
    public MenuItem buttonMyMovies;
    public MenuButton menu;

    public Label labelWelcome;

    /**
     * method which switches the display from home to movies section
     * @param actionEvent
     * @throws IOException
     */
    public void showMovies(ActionEvent actionEvent) throws IOException {
        Stage stage1=(Stage) menu.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/movies.fxml"));
        Parent root = fxmlloader.load();
        stage1.setTitle("Movies");
        //  stage.getIcons().add(new Image("/src/main/resources/img/download"));
        stage1.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
    }

    /**
     * method which switches the display from home to mymovies section
     * @param actionEvent
     * @throws IOException
     */
    public void showMyMovies(ActionEvent actionEvent) throws IOException {
        Stage stage1=(Stage) menu.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/mymovies.fxml"));
        Parent root = fxmlloader.load();
        stage1.setTitle("My Movies");
        stage1.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
    }

    /**
     * method which logs out the user and goes back to the log in screen
     * @param actionEvent
     * @throws IOException
     */
    public void showLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) menu.getScene().getWindow();
        Stage stage1 = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Movie");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.close();
        stage.show();
    }

}
