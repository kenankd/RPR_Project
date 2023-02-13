package ba.unsa.etf.rpr.controllers;

import javafx.scene.control.Alert;

/**
 * @author Kenan Dizdarevic
 * Class which is used for help, it displays an alert of given information
 */
public class AlertDisplay {
    /**
     * method which displays an alert on screen
     * @param title of alert
     * @param header of alert
     * @param content of alert
     */
    public static void showAlert(String title, String header, String content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(content);
        alert.show();
    }
}
