package ba.unsa.etf.rpr.controllers;

import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {
    public TextField fieldUsername;
    public PasswordField fieldPassword;
    public void buttonLogIn(){
        if(fieldUsername.getText().trim().isEmpty()){
          //  Alert alert = new Alert(Alert.AlertType.WARNING);
           // alert.setTitle("Warning Dialog");
           // alert.setHeaderText("Look, a Warning Dialog");
            //alert.setContentText("Careful with the next step!");

            //alert.showAndWait();
        }
        System.out.println("namjesti mladog kapitena bolje igra"+ fieldPassword.getText());
    }
}
