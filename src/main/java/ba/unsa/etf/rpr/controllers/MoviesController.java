package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.CustomerManager;
import ba.unsa.etf.rpr.business.MovieManager;
import ba.unsa.etf.rpr.business.PurchaseManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Controller class which controls everything behind the movies display
 */
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
    public Button buttonBuy;
    @FXML
    private TableView customer_table;
    @FXML
    private ObservableList<Movie> movieList =FXCollections.observableArrayList();
    private final MovieManager movieManager = new MovieManager();
    private final PurchaseManager purchaseManager = new PurchaseManager();
    private final CustomerManager customerManager = new CustomerManager();

    /** method which is used to set the tableview before displaying the window
     * it also implements searching of movies using a listener
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<Movie> list = movieManager.getAll();
        for(int i=0;i<list.size();i++){
            movieList.add(new Movie(list.get(i).getId(),list.get(i).getTitle(),list.get(i).getRelease_date(),list.get(i).getMain_actor(),list.get(i).getPrice(),list.get(i).getLength(),list.get(i).getGenre()));
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

    /**
     * method which switches movies display to home screen
     * @param actionEvent
     * @throws Exception
     */
    public void showHome(ActionEvent actionEvent) throws Exception{
        Stage stage=(Stage) customer_table.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/home.fxml"));
        Parent root = fxmlloader.load();
        HomeController homecontroller = fxmlloader.getController();
        if(LoginController.getUsername() != null)
            homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+LoginController.getUsername() + "!");
        else homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+RegisterController.username + "!");
        stage.setScene(new Scene(root,600,430));
    }

    /**
     * method which adds the selected movie in the registered user's movie collection
     * @param actionEvent
     */
    public void actionBuy(ActionEvent actionEvent) {
        Movie movie = (Movie) customer_table.getSelectionModel().getSelectedItem();
        if(movie==null){
            AlertDisplay.showAlert("Warning","No movies selected","Please select the movie that you want to purchase");
            return;
        }

        Customer customer;
        if(LoginController.getUsername() != null)
            customer = customerManager.searchByUsername(LoginController.getUsername());
        else
            customer = customerManager.searchByUsername(RegisterController.username);
        try{
            PurchaseManager purchaseManager=new PurchaseManager();
            purchaseManager.isPurchaseAlreadyMade(customer,movie);
        } catch (MovieException e) {
            AlertDisplay.showAlert("Warning", "Movie purchase error", "You already purchased this movie");
        }
        java.sql.Date date=new java.sql.Date(System.currentTimeMillis());
        purchaseManager.add(new Purchase(movie,customer,date));
    }

    /**
     * method which switches display from movies to mymovies
     * @param actionEvent
     * @throws IOException
     */
    public void showMyMovies(ActionEvent actionEvent) throws IOException {
        Stage stage=(Stage) customer_table.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/mymovies.fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle("My Movies");
        stage.setScene(new Scene(root,600,430));
    }
}
