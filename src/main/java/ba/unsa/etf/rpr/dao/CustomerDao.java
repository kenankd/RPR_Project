package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.List;

/**
 * Dao interface for Customer domain
 * @author Kenan Dizdarevic
 */
public interface CustomerDao extends Dao<Customer> {
    /**
     * Returns all customers with given name
     * @param name search based on this parameter
     * @return list of customers
     * @throws MovieException
     */
     List<Customer> searchByName(String name) throws MovieException;

    /**
     * Returns all customers with given surname
     * @param surname search based on this parameter
     * @return list of customers
     * @throws MovieException
     */
    List<Customer> searchBySurname(String surname) throws MovieException;

    /**
     * Returns all customers with given username
     * @param username search based on this parameter
     * @return one customer because username is unique
     * @throws MovieException
     */
    Customer searchByUsername(String username) throws MovieException;

}
