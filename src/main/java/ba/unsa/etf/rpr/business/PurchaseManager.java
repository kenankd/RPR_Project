package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.controllers.AlertDisplay;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.List;

public class PurchaseManager {
    public List<Purchase> getAll() throws MovieException {
        return DaoFactory.purchaseDao().getAll();
    }

    public void delete(int id) throws MovieException {
        DaoFactory.purchaseDao().delete(id);
    }

    public Purchase add(Purchase item) throws MovieException {
        return DaoFactory.purchaseDao().add(item);
    }

    public Purchase update(Purchase item) throws MovieException {
        return DaoFactory.purchaseDao().update(item);
    }

    public void isPurchaseAlreadyMade(Customer customer, Movie movie) {
        PurchaseManager purchaseManager = new PurchaseManager();
        List<Purchase> purchaseList = purchaseManager.getAll();
        for (int i = 0; i < purchaseList.size(); i++) {
            if (purchaseList.get(i).getMovie().getId() == movie.getId() && purchaseList.get(i).getCustomer().getId() == customer.getId()) {
                throw new MovieException("This purchase has already been made");
            }
        }
    }
}
