package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerDaoSQLImplementation implements CustomerDao {
    private Connection connection;
    public CustomerDaoSQLImplementation(){
        try{
            connection= DriverManager.getConnection("jdbc:mysql://sq7.freemysqlhosting.net:3306/sql7584050","sql7584050","mVSKqJ5z1H");
        } catch (SQLException e) {
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
                c.setIdcustomer(rs.getInt("customer_id"));
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
                c.setIdcustomer(rs.getInt("customer_id"));
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
                c.setIdcustomer(rs.getInt("customer_id"));
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
                c.setIdcustomer(rs.getInt("customer_id"));
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
