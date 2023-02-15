package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.List;

/**
 * Business logic layer for TableView in MyMovies section
 * @author Kenan Dizdarevic
 */
public class PurchaseTableViewModelManager {
    public List<PurchaseTableViewModel> getMyMovies(String username) throws MovieException {
        return DaoFactory.purchaseDao().getMyMovies(username);
    }
}
