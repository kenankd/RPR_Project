package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class CustomerDaoSQLImplementation extends AbstractDao<Customer> implements CustomerDao {

    public CustomerDaoSQLImplementation(){
        super("Customer");
    }
    @Override
    public List<Customer> searchByName(String name) throws MovieException {
        List<Customer> list=new ArrayList<>();
        try{
            PreparedStatement s=getConnection().prepareStatement("select * from Customer where name LIKE concat('%',?,'%')");
            s.setString(1,name);
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Customer> searchBySurname(String surname) {
        List<Customer> list=new ArrayList<>();
        try{
            PreparedStatement s=getConnection().prepareStatement("select * from Customer where surname LIKE concat('%',?,'%')");
            s.setString(1,surname);
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<Customer> searchByUsername(String username) throws MovieException {
        List<Customer> list=new ArrayList<>();
        try{
            PreparedStatement s=getConnection().prepareStatement("select * from Customer where username = ?");
            s.setString(1,username);
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                list.add(row2object(rs));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
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
        map.put("pw",object.getPw());
        map.put("username",object.getUsername());
        return map;
    }
}
