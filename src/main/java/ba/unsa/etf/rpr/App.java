package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Movie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.List;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;

/**
 * Hello world!
 *
 */
public class App {

    public static void main(String[] args) {
        List<Movie> list = DaoFactory.movieDao().getAll();
    }
}

