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
        String add = "INSERT INTO Customer(name,surname,mail,address,phone_number) VALUES(?,?,?,?,?)";
        try{
            PreparedStatement ps=this.connection.prepareStatement(add,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,item.getName());
            ps.setString(2,item.getSurname());
            ps.setString(3,item.getMail());
            ps.setString(4,item.getAdress());
            ps.setString(5,item.getPhone_number());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            item.setCustomer_id(rs.getInt(1));
            return item;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Customer update(Customer item) {
        try{
            PreparedStatement ps=connection.prepareStatement("UPDATE Customer SET name=?,surname=?,mail=?,address=?,phone_number=? where customer_id=?");
            ps.setString(1,item.getName());
            ps.setString(2,item.getSurname());
            ps.setString(3,item.getMail());
            ps.setString(4,item.getAdress());
            ps.setString(5,item.getPhone_number());
            ps.setInt(6,item.getCustomer_id());
            ps.executeUpdate();
            return item;

        } catch (SQLException e) {
            e.printStackTrace();

        }
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
