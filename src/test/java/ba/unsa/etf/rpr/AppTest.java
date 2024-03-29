package ba.unsa.etf.rpr;


import ba.unsa.etf.rpr.business.CustomerManager;
import ba.unsa.etf.rpr.business.MovieManager;
import ba.unsa.etf.rpr.business.PurchaseManager;
import ba.unsa.etf.rpr.dao.CustomerDao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.MovieDao;
import ba.unsa.etf.rpr.dao.PurchaseDao;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Unit tests for Movie Online rent App.
 */
public class AppTest 
{
    MovieManager movieManager = new MovieManager();
    CustomerManager customerManager = new CustomerManager();
    PurchaseManager purchaseManager = new PurchaseManager();
    /**
     * Test of username being allowed to be only between 5 and 15 characters
     */
    @Test
    public void usernameLogInTest()
    {
        assertThrows(MovieException.class,()->{
            customerManager.checkUsername("aaaa");
        });
    }
    /**
     * Test of password being allowed to be only between 8 and 20 characters
     */
    @Test
    public void passwordLogInTest(){
        assertThrows(MovieException.class,()->{
           customerManager.checkPassword("123456789123456789123456789");
        });
    }

    /**
     * Test of Log In for a user I know is registered
     */
    @Test
    public void LogInTest(){
        assertDoesNotThrow(()->{
            customerManager.checkLogIn("edindzeko","edindzeko");
        });
    }
    @Test
    public void searchByTitle(){
        List<Movie> list = movieManager.getAll();
        Movie movie = list.get(1);
        Movie movie2=movieManager.searchByTitle(movie.getTitle()).get(0);
        assertEquals(movie.getGenre(),movie2.getGenre());
    }

    /**
     * Tests if adding a movie to the database is correctly done
     */
    @Test
    public void addMovie(){
        Movie movie = new Movie();
        movie.setTitle("aaaadsdadas");
        movie.setMain_actor("dasdasd");
        movie.setRelease_date(Date.valueOf(LocalDate.now()));
        movie.setGenre("horror");
        movie.setPrice(33);
        movie.setLength(120);
        movieManager.add(movie);
        boolean found = false;
        List<Movie> movies=movieManager.getAll();
        Movie movie1 = movies.get(movies.size()-1);
        assertEquals(movie.getId(),movie1.getId());
        movieManager.delete(movie1.getId());
    }
    @Test
    public void searchByCustomerName(){
        Customer c = customerManager.searchByUsername("edzeko1");
        assertEquals(c.getName(),"Edin");
    }

    @Test
    public void pwTest() {
        CustomerManager cmm=new CustomerManager();
        CustomerManager cm = Mockito.mock(CustomerManager.class);
        Customer c = new Customer("a","b","c","dsadsada","dadasdas");
        List<Customer> customers=new ArrayList<>();
        customers.add(c);
        Mockito.when(cm.getAll()).thenReturn(customers);
        assertDoesNotThrow(()->{
            cmm.checkPassword(c.getPw());
        });
    }

}
