package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;


import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PurchaseDaoSQLImplementation extends AbstractDao<Purchase> implements PurchaseDao{
    private Connection connection;
    public PurchaseDaoSQLImplementation() {
        super("Purchase");
    }

    @Override
    public List<Purchase> getByMovie(Movie movie) throws MovieException {
        List<Purchase> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement("select * from Purchase where movie = ?");
            s.setInt(1, movie.getId());
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            throw new MovieException(e.getMessage(),e);
        }
        return list;
    }

    @Override
    public List<Purchase> getByCustomer(Customer customer) throws MovieException {
        List<Purchase> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement("select * from Purchase where customer = ?");
            s.setInt(1, customer.getId());
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            throw new MovieException(e.getMessage(),e);
        }
        return list;
    }

    @Override
    public List<Purchase> getByDate(java.util.Date date) throws MovieException {
        List<Purchase> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement("select * from Purchase where date_of_rent = ?");
            s.setDate(1, (java.sql.Date) date);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            throw new MovieException(e.getMessage(),e);
        }
        return list;
    }



    @Override
    public Purchase row2object(ResultSet rs) throws MovieException {
        try{
            Purchase p = new Purchase();
            p.setId(rs.getInt("id"));
            p.setCustomer(DaoFactory.customerDao().getById(rs.getInt("customer")));
            p.setMovie(DaoFactory.movieDao().getById(rs.getInt("movie")));
            p.setDate_of_rent(rs.getDate("date_of_rent"));
            return p;
        } catch (SQLException e) {
            throw new MovieException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Purchase object) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", object.getId());
        map.put("movie", object.getMovie().getId());
        map.put("date_of_rent", object.getDate_of_rent());
        map.put("customer",object.getCustomer().getId());
        return map;
    }
}
