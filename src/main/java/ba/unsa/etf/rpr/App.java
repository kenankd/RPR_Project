package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.CustomerDao;
import ba.unsa.etf.rpr.dao.CustomerDaoSQLImplementation;
import ba.unsa.etf.rpr.dao.MovieDaoSQLImplementation;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.exceptions.ConnectionException;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        CustomerDaoSQLImplementation a=new CustomerDaoSQLImplementation();
        Customer cc=a.add(new Customer(3,"Kenan","Dizdarevic","a","b","c"));

    }
}

