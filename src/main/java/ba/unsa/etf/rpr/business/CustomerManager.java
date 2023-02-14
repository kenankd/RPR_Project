package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Business Logic Layer for management of Customers
 */
public class CustomerManager {
    public List<Customer> getAll() throws MovieException {
        return DaoFactory.customerDao().getAll();
    }
    public void delete(int id) throws MovieException {
        DaoFactory.customerDao().delete(id);
    }
    public Customer add(Customer item) throws MovieException{
        return DaoFactory.customerDao().add(item);
    }
    public Customer update(Customer item) throws MovieException{
        return DaoFactory.customerDao().update(item);
    }
    public Customer searchByUsername(String username) throws MovieException {
        return DaoFactory.customerDao().searchByUsername(username);
    }
    public void checkUsernameForRegistration(String username){
        if(username.trim().isEmpty() )
            throw new MovieException("Username field empty");
        else if(username.trim().length()<5 || username.trim().length()>15)
            throw new MovieException("Username needs to be between 5 and 15 characters long!");
        else if (searchByUsername(username.trim()) != null)
            throw new MovieException("Account with given username already exists!");
    }
    public void checkUsername(String username){
        if(username.trim().isEmpty() )
            throw new MovieException("Username field empty");
        else if(username.trim().length()<5 || username.trim().length()>15)
            throw new MovieException("Username needs to be between 5 and 15 characters long!");
    }
    public void checkPassword(String password){
        if(password.trim().isEmpty()) throw new MovieException("Password field empty");
        else if(password.trim().length()<8 || password.trim().length()>20) throw new MovieException("Password needs to be between 8 and 20 characters long!");
    }
    public void checkLogIn(String username, String password){
        checkUsername(username);
        checkPassword(password);
        CustomerManager customerManager=new CustomerManager();
        Customer customer = customerManager.searchByUsername(username);
        if(customer == null) throw new MovieException("No user is registered with given username!");
        if(!customer.getPw().equals(password)) throw new MovieException("Password incorrect!");
    }
    public void checkFieldEmpty(ArrayList<String> fields){
        for(String s : fields)
            if(s.trim().isEmpty()) throw new MovieException("Text field cannot be blank!");
    }
}
