package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.business.PurchaseTableViewModel;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;


import java.sql.*;
import java.util.*;

public class PurchaseDaoSQLImplementation extends AbstractDao<Purchase> implements PurchaseDao{
    private static PurchaseDaoSQLImplementation instance = null;
    public PurchaseDaoSQLImplementation() {
        super("Purchase");
    }
    public static PurchaseDaoSQLImplementation getInstance(){
        if(instance == null) instance = new PurchaseDaoSQLImplementation();
        return instance;
    }
    public static void removeInstance(){
        if(instance!=null) instance=null;
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

    /**
     * @param username
     */
    @Override
    public List<PurchaseTableViewModel> getMyMovies(String username) throws MovieException {

        List<PurchaseTableViewModel> list = new ArrayList<>();
        try {
            PreparedStatement s = getConnection().prepareStatement("select m.title as title,m.main_actor as main_actor,m.genre as genre,m.price as price,p.date_of_rent as date_of_rent  from Movie m, Purchase p, Customer c where m.id=p.movie and c.id=p.customer and c.username=?");
            s.setString(1, username);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                try{
                    PurchaseTableViewModel p = new PurchaseTableViewModel();
                    p.setTitle(rs.getString("title"));
                    p.setMain_actor(rs.getString("main_actor"));
                    p.setGenre(rs.getString("genre"));
                    p.setPrice(rs.getDouble("price"));
                    p.setPurchase_date(rs.getDate("date_of_rent"));
                    list.add(p);
                } catch (SQLException e) {
                    throw new MovieException(e.getMessage(),e);
                }
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
