package ba.unsa.etf.rpr.controllers;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
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
    private void switchScene(String fxml) throws IOException {
        Stage stage=(Stage) myMoviesTable.getScene().getWindow();
        FXMLLoader fxmlloader=new FXMLLoader(getClass().getResource("/fxml/"+fxml+".fxml"));
        Parent root = fxmlloader.load();
        stage.setTitle(fxml);
        if(fxml.equals("home")){
            HomeController homecontroller = fxmlloader.getController();
            homecontroller.labelWelcome.setText(homecontroller.labelWelcome.getText()+LoginController.getUsername() + "!");
        }
        stage.setScene(new Scene(root,USE_COMPUTED_SIZE,USE_COMPUTED_SIZE));
    }

    public void showHome(ActionEvent actionEvent) throws IOException {
        switchScene("home");
    }

    public void showMovies(ActionEvent actionEvent) throws IOException {
        switchScene("movies");
    }

    /**
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        List<PurchaseTableViewModel> list = DaoFactory.purchaseDao().getMyMovies(LoginController.getUsername());
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
