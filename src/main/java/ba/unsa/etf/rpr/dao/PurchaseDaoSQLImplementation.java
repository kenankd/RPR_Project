package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.SingletonConnection;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.ConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PurchaseDaoSQLImplementation implements PurchaseDao{
    private Connection connection;
    public PurchaseDaoSQLImplementation() {
        try {
            connection = SingletonConnection.getInstance();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Purchase getById(int id) {
        try {
            PreparedStatement s = connection.prepareStatement("select * from Purchase where purchase_id _= ?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Purchase c = new Purchase();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMovie_id(rs.getInt("movie_id"));
                c.setDate_of_rent(rs.getDate("purchase_date"));
                c.setRent_id(rs.getInt("rent_id"));
                rs.close();
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
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
        String delete = "DELETE FROM Purchase WHERE purchase_id = ?";
        try {
            PreparedStatement s = connection.prepareStatement(delete);
            s.setInt(1, id);
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Purchase> getAll() {
        List<Purchase> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Purchase");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Purchase c = new Purchase();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMovie_id(rs.getInt("movie_id"));
                c.setDate_of_rent(rs.getDate("purchase_date"));
                c.setRent_id(rs.getInt("rent_id"));
                lista.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Purchase> getByMovieId(int movie_id) {
        List<Purchase> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Purchase where movie_id= ?");
            s.setInt(1,movie_id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Purchase c = new Purchase();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMovie_id(rs.getInt("movie_id"));
                c.setDate_of_rent(rs.getDate("purchase_date"));
                c.setRent_id(rs.getInt("rent_id"));
                lista.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Purchase> getByCustomerId(int customer_id) {
        List<Purchase> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Purchase where customer_id= ?");
            s.setInt(1,customer_id);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Purchase c = new Purchase();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMovie_id(rs.getInt("movie_id"));
                c.setDate_of_rent(rs.getDate("purchase_date"));
                c.setRent_id(rs.getInt("rent_id"));
                lista.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Purchase> getByDate(Date date) {
        List<Purchase> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Purchase where purchase_date= ?");
            s.setDate(1, (java.sql.Date) date);
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Purchase c = new Purchase();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMovie_id(rs.getInt("movie_id"));
                c.setDate_of_rent(rs.getDate("purchase_date"));
                c.setRent_id(rs.getInt("rent_id"));
                lista.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}
