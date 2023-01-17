package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
    @FXML
    private ObservableList<Movie> movieList =FXCollections.observableArrayList();

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Movie> list = DaoFactory.movieDao().getAll();
        for(int i=0;i<list.size();i++){
            movieList.add(new Movie(i,list.get(i).getTitle(),list.get(i).getRelease_date(),list.get(i).getMain_actor(),list.get(i).getPrice(),list.get(i).getLength(),list.get(i).getGenre()));
        }
        column_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        column_mainactor.setCellValueFactory(new PropertyValueFactory<>("main_actor"));
        column_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        column_date.setCellValueFactory(new PropertyValueFactory<>("release_date"));
        column_length.setCellValueFactory(new PropertyValueFactory<>("length"));
        column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        customer_table.setItems(movieList);



    }

}
