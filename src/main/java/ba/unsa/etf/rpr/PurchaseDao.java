package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.List;

public interface PurchaseDao extends Dao<Purchase>{
    /**
     * lists all purchases of a given movie
     * @param movie_id title of movie
     * @return list of purchases
     */
    List<Purchase> getByMovieId(int movie_id);
    /**
     * lists all purchases of a given customer
     * @param customer_id primary key from entity customer
     * @return list of purchases
     */
    List<Purchase> getByCustomerId(int customer_id);
    /**
     * lists all purchases from a given date
     * @param date date of purchase
     * @return list of purchases
     */
    List<Purchase> getByDate(Date date);
}
