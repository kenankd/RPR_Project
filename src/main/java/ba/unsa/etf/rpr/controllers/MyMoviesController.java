package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.business.PurchaseTableViewModel;
import ba.unsa.etf.rpr.business.PurchaseTableViewModelManager;
import ba.unsa.etf.rpr.dao.DaoFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Controller class which controls everything behind the mymovies display
 */
public class MyMoviesController implements Initializable {
    @FXML
    public TableView myMoviesTable;
    @FXML
    public TableColumn column_itle;
    @FXML
    public TableColumn column_main_actor;
    @FXML
    public TableColumn column_genre;
    @FXML
    public TableColumn column_price;
    @FXML
    public TableColumn column_date;
    @FXML
    private ObservableList<PurchaseTableViewModel> movieList = FXCollections.observableArrayList();
    private final PurchaseTableViewModelManager purchaseTableViewModelManager=new PurchaseTableViewModelManager();
    private void switchScene(String fxml) throws IOException {
        Stage stage=(Stage) myMoviesTable.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/"+fxml+".fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle(fxml);
        if(fxml.equals("home")){
            HomeController homecontroller = fxmlloader.getController();
            if(LoginController.getUsername() != null)
            homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+LoginController.getUsername() + "!");
            else homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+RegisterController.username + "!");
        }
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
    }

    /**
     * method which switches mymovies display to home screen
     * @param actionEvent
     * @throws IOException
     */
    public void showHome(ActionEvent actionEvent) throws IOException {
        switchScene("home");
    }

    /**
     * method which switches mymovies display to movies screen
     * @param actionEvent
     * @throws IOException
     */
    public void showMovies(ActionEvent actionEvent) throws IOException {
        switchScene("movies");
    }

    /**
     * method which is used to set the tableview before displaying the window
     *
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<PurchaseTableViewModel> list;
        if(LoginController.getUsername() != null)
        list = purchaseTableViewModelManager.getMyMovies(LoginController.getUsername());
        else list = purchaseTableViewModelManager.getMyMovies(RegisterController.username);
        for(int i=0;i<list.size();i++){
            movieList.add(new PurchaseTableViewModel(list.get(i).getTitle(),list.get(i).getMain_actor(),list.get(i).getGenre(),list.get(i).getPrice(),list.get(i).getPurchase_date()));
        }
        column_itle.setCellValueFactory(new PropertyValueFactory<>("title"));
        column_main_actor.setCellValueFactory(new PropertyValueFactory<>("main_actor"));
        column_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        column_date.setCellValueFactory(new PropertyValueFactory<>("purchase_date"));
        column_price.setCellValueFactory(new PropertyValueFactory<>("price"));
        myMoviesTable.setItems(movieList);
    }
}
