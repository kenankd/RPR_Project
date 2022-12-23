package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.Date;
import java.util.List;

public interface PurchaseDao extends Dao<Purchase> {
    /**
     * lists all purchases of a given movie
     * @param movie  movie
     * @return list of purchases
     */
    List<Purchase> getByMovie(Movie movie) throws MovieException;
    /**
     * lists all purchases of a given customer
     * @param customer  customer
     * @return list of purchases
     */
    List<Purchase> getByCustomer(Customer customer) throws MovieException;
    /**
     * lists all purchases from a given date
     * @param date date of purchase
     * @return list of purchases
     */
    List<Purchase> getByDate(Date date) throws MovieException;
}
