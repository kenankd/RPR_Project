package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CustomerManager;
import ba.unsa.etf.rpr.domain.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * @author Kenan Dizdarevic
 * Controller class which controls everything behind the register display
 */
public class RegisterController {
    public Button buttonRegister;
    public TextField fieldName;
    public TextField fieldSurname;
    public TextField fieldMail;
    public TextField fieldUsername;
    public PasswordField fieldPassword;
    private final CustomerManager customerManager = new CustomerManager();

    public static String username ;

    /**
     * method which adds the new user to the database if the rules are followed
     * @param actionEvent
     * @throws IOException
     */
    public void buttonRegister(ActionEvent actionEvent) throws IOException {
        try{
            customerManager.checkFieldEmpty(new ArrayList<String>(Arrays.asList(fieldName.getText(),fieldSurname.getText(),
                    fieldMail.getText(),fieldUsername.getText(),fieldPassword.getText())));
            customerManager.checkUsernameForRegistration(fieldUsername.getText());
            customerManager.checkPassword(fieldPassword.getText());
        } catch (Exception e) {
            AlertDisplay.showAlert("Error", "Registration failed", e.getMessage());
            return;
        }
        customerManager.add(new Customer(fieldName.getText().trim(),fieldSurname.getText().trim(),fieldMail.getText().trim(),fieldUsername.getText().trim(),fieldPassword.getText().trim()));
        Stage stage=(Stage) fieldUsername.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = fxmlloader.load();
        stage1.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        HomeController homecontroller = fxmlloader.getController();
        homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+fieldUsername.getText() + "!");
        stage1.show();
        username=fieldUsername.getText().trim();
    }

    /**
     * method which displays the login screen if the user is already registered
     * @param actionEvent
     * @throws IOException
     */
    public void buttonLogIn(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) fieldPassword.getScene().getWindow();
        stage.close();
        Stage stage1 = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/login.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Movie");
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }
}
