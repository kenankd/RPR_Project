package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
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

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

public class RegisterController {
    public Button buttonRegister;
    public TextField fieldName;
    public TextField fieldSurname;
    public TextField fieldMail;
    public TextField fieldUsername;
    public PasswordField fieldPassword;

    public void Register(ActionEvent actionEvent) {

    }

    public void buttonRegister(ActionEvent actionEvent) {
        if(buttonRegister.getText().trim().isEmpty() || fieldName.getText().trim().isEmpty() || fieldSurname.getText().trim().isEmpty() ||
                fieldMail.getText().trim().isEmpty() || fieldUsername.getText().trim().isEmpty() || fieldPassword.getText().trim().isEmpty()) {
            ControllerHelper.showAlert("Error", "Text field blank", "Text fields cannot be blank!");
        }
        else if(fieldUsername.getText().trim().length()<5 || fieldUsername.getText().trim().length()>15)
            ControllerHelper.showAlert("Error", "Username length invalid", "Username needs to be between 5 and 15 characters long!");
        else if(fieldPassword.getText().trim().length()<8 || fieldPassword.getText().trim().length()>20)
            ControllerHelper.showAlert("Error", "Password length invalid", "Password needs to be between 8 and 20 characters long!");
        else if(DaoFactory.customerDao().searchByUsername(fieldUsername.getText().trim()) != null)
            ControllerHelper.showAlert("Error", "Username taken", "Someone has already registrated with entered username");
        else{
            DaoFactory.customerDao().add(new Customer(fieldName.getText().trim(),fieldSurname.getText().trim(),fieldMail.getText().trim(),fieldUsername.getText().trim()
                    ,fieldPassword.getText().trim()));
        }
    }

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
