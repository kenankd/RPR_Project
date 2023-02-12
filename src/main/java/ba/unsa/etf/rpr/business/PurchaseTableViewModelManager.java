package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.List;

public class PurchaseTableViewModelManager {
    public List<PurchaseTableViewModel> getMyMovies(String username) throws MovieException {
        return DaoFactory.purchaseDao().getMyMovies(username);
    }
}
