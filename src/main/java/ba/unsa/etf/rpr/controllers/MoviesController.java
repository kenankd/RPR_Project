package ba.unsa.etf.rpr.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MoviesController implements Initializable {
    @FXML
    public TableColumn column_title;
    @FXML
    public TableColumn column_mainactor;
    @FXML
    public TableColumn column_genre;
    @FXML
    public TableColumn column_date;
    @FXML
    public TableColumn column_length;
    @FXML
    public TableColumn column_price;
    @FXML
    private TableView customer_table;

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
