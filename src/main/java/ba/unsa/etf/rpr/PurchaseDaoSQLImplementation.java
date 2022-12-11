package ba.unsa.etf.rpr;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class PurchaseDaoSQLImplementation implements PurchaseDao{
    private Connection connection;

    @Override
    public Purchase getById(int id) {
        return null;
    }

    @Override
    public Purchase add(Purchase item) {
        return null;
    }

    @Override
    public Purchase update(Purchase item) {
        return null;
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<Purchase> getAll() {
        return null;
    }

    @Override
    public List<Purchase> getByMovieId(int movie_id) {
        return null;
    }

    @Override
    public List<Purchase> getByCustomerId(int customer_id) {
        return null;
    }

    @Override
    public List<Purchase> getByDate(Date date) {
        return null;
    }
}
