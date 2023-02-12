package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.Dao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.List;

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
}
