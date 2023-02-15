package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CustomerManager;
import ba.unsa.etf.rpr.business.PurchaseManager;
import ba.unsa.etf.rpr.domain.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * @author Kenan Dizdarevic
 * Controller class which controlls everything happening behind the scenes for the Log In display
 */
public class LoginController {
    public TextField fieldUsername;
    public PasswordField fieldPassword;

    public static String username ;
    private final CustomerManager customerManager=new CustomerManager();

    /**
     * method which represents logging in the app
     * if credentials are right the home screen will display
     * @param actionevent
     * @throws IOException
     */

    public void buttonLogIn(ActionEvent actionevent) throws IOException {
        try{
            customerManager.checkLogIn(fieldUsername.getText(),fieldPassword.getText());
        } catch (Exception e) {
            AlertDisplay.showAlert("Error","Invalid input!",e.getMessage());
            return;
        }
            Stage stage=(Stage) fieldUsername.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            Parent root = fxmlloader.load();
            stage1.setScene(new Scene(root,600,430));
            HomeController homecontroller = fxmlloader.getController();
            homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+fieldUsername.getText() + "!");
            stage1.show();
            username=fieldUsername.getText();
    }

    /**
     * static method which returns username, it is used in other controllers to recognize the user that logged in
     * @return username
     */
    public static String getUsername(){
        return username;
    }

    /**
     * method whichs switches scene and displays the registration display
     * @param actionevent
     * @throws IOException
     */
    public void registerButton(ActionEvent actionevent) throws IOException {
        Stage stage1=(Stage) fieldUsername.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Movie");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }
}
