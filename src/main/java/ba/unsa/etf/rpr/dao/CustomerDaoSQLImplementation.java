package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomerDaoSQLImplementation extends AbstractDao<Customer> implements CustomerDao {
    private static CustomerDaoSQLImplementation instance = null;
    public static CustomerDaoSQLImplementation getInstance(){
        if(instance == null) instance = new CustomerDaoSQLImplementation();
        return instance;
    }
    public static void removeInstance(){
        if(instance!=null) instance=null;
    }

    public CustomerDaoSQLImplementation(){
        super("Customer");
    }
    @Override
    public List<Customer> searchByName(String name) throws MovieException {
        return executeQuery("select * from Customer where name LIKE concat('%',?,'%')",new Object[]{name});
    }

    @Override
    public List<Customer> searchBySurname(String surname) {
        return executeQuery("select * from Customer where surname LIKE concat('%',?,'%')",new Object[]{surname});
    }

    @Override
    public Customer searchByUsername(String username) throws MovieException {
        return executeQueryUnique("select * from Customer where username = ?",new Object[]{username});

    }
    @Override
    public Customer row2object(ResultSet rs) throws MovieException {
        try{
            Customer c = new Customer();
            c.setId(rs.getInt("id"));
            c.setName(rs.getString("name"));
            c.setSurname(rs.getString("surname"));
            c.setMail(rs.getString("mail"));
            c.setPw(rs.getString("pw"));
            c.setUsername(rs.getString("username"));
            return c;
        } catch (SQLException e) {
            throw new MovieException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Customer object) {
        Map<String,Object> map=new TreeMap<>();
        map.put("id",object.getId());
        map.put("name",object.getName());
        map.put("surname",object.getSurname());
        map.put("mail",object.getMail());
        map.put("username",object.getUsername());
        map.put("pw",object.getPw());
        return map;
    }
}
