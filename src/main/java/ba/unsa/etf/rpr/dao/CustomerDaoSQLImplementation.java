package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.SingletonConnection;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.exceptions.ConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoSQLImplementation implements CustomerDao {
    private Connection connection;
    public CustomerDaoSQLImplementation(){
        try{
            connection = SingletonConnection.getInstance();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Customer> searchByName(String name) {
        List<Customer> list=new ArrayList<>();
        try{
            PreparedStatement s=connection.prepareStatement("select * from Customer where name = ?");
            s.setString(1,name);
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                Customer c= new Customer();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMail(rs.getString("mail"));
                c.setAdress(rs.getString("address"));
                c.setName(rs.getString("name"));
                c.setSurname(rs.getString("surname"));
                c.setPhone_number(rs.getString("phone_number"));
                list.add(c);
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
            PreparedStatement s=connection.prepareStatement("select * from Customer where surname = ?");
            s.setString(1,surname);
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                Customer c= new Customer();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMail(rs.getString("mail"));
                c.setAdress(rs.getString("address"));
                c.setName(rs.getString("name"));
                c.setSurname(rs.getString("surname"));
                c.setPhone_number(rs.getString("phone_number"));
                list.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Customer getById(int id) {
        try{
            PreparedStatement s=connection.prepareStatement("select * from Customer where customer_id _= ?");
            s.setInt(1,id);
            ResultSet rs=s.executeQuery();
            if(rs.next()){
                Customer c= new Customer();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMail(rs.getString("mail"));
                c.setAdress(rs.getString("address"));
                c.setName(rs.getString("name"));
                c.setSurname(rs.getString("surname"));
                c.setPhone_number(rs.getString("phone_number"));
                rs.close();
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer add(Customer item) {
        return null;
    }

    @Override
    public Customer update(Customer item) {
        return null;
    }

    @Override
    public void delete(int id) {
        String delete="DELETE FROM Customer WHERE customer_id = ?";
        try{
            PreparedStatement s=connection.prepareStatement(delete);
            s.setInt(1,id);
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Customer> getAll() {
        List<Customer> list=new ArrayList<>();
        try{
            PreparedStatement s= connection.prepareStatement("Select * from Customer");
            ResultSet rs=s.executeQuery();
            while(rs.next()){
                Customer c= new Customer();
                c.setCustomer_id(rs.getInt("customer_id"));
                c.setMail(rs.getString("mail"));
                c.setAdress(rs.getString("address"));
                c.setName(rs.getString("name"));
                c.setSurname(rs.getString("surname"));
                c.setPhone_number(rs.getString("phone_number"));
                list.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
