package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Customer;

import java.util.List;

public interface CustomerDao extends Dao<Customer> {
    /**
     * Returns all customers with given name
     * @param name search based on this parameter
     * @return list of customers
     */
     List<Customer> searchByName(String name);

    /**
     * Returns all customers with given surname
     * @param surname search based on this parameter
     * @return list of customers
     */
    List<Customer> searchBySurname(String surname);
}
