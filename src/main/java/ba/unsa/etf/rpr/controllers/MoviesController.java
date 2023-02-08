package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Movie;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

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
    public TextField searchTextField;
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

        FilteredList<Movie> filteredData = new FilteredList<>(movieList);
        searchTextField.textProperty().addListener((observable,oldValue,newValue) ->{
            filteredData.setPredicate(Movie -> {

                if(newValue==null || newValue.isEmpty()) return true;
                String lowerCaseFilter=newValue.toLowerCase();
                if(Movie.getTitle().toLowerCase().indexOf(lowerCaseFilter)!=-1) return true;
                else return false;
            });
        });
        SortedList<Movie> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(customer_table.comparatorProperty());
        customer_table.setItems(sortedData);
    }
    public void showHome(ActionEvent actionEvent) throws Exception{
        Stage stage=(Stage) customer_table.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = fxmlloader.load();
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));


        //stage.show();   

    }

}
