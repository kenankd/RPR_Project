package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
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


public class LoginController {
    public TextField fieldUsername;
    public PasswordField fieldPassword;

    public static String s ;

    public void buttonLogIn(ActionEvent actionevent) throws IOException {

        if (fieldUsername.getText().trim().isEmpty() || fieldPassword.getText().trim().isEmpty()) {
            ControllerHelper.showAlert("Error","Text field blank","Text fields cannot be blank!");
            return;
        }
        Customer c= DaoFactory.customerDao().searchByUsername(fieldUsername.getText());
        if(c==null)
            ControllerHelper.showAlert("Error","Username not found!","No user is registered with given username");
        else if(!fieldPassword.getText().equals(c.getPw()))
            ControllerHelper.showAlert("Error","Incorrect password!","Your password is not correct, try again!");
        else{
            Stage stage=(Stage) fieldUsername.getScene().getWindow();
            stage.close();
            Stage stage1 = new Stage();
            FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
            Parent root = fxmlloader.load();
            stage1.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
            HomeController homecontroller = fxmlloader.getController();
            homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+fieldUsername.getText() + "!");
            stage1.show();
            s=fieldUsername.getText();
        }
    }
    public static String getS(){
        return s;
    }
    public void registerButton(ActionEvent actionevent) throws IOException {
        Stage stage1=(Stage) fieldUsername.getScene().getWindow();
        stage1.close();
        Stage stage = new Stage();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/register.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("Movie");
        //  stage.getIcons().add(new Image("/src/main/resources/img/download"));
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
        stage.show();
    }
}
