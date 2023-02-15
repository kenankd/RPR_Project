package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.business.CustomerManager;
import ba.unsa.etf.rpr.business.PurchaseManager;
import ba.unsa.etf.rpr.dao.CustomerDao;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.MovieDao;
import ba.unsa.etf.rpr.dao.PurchaseDao;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Kenan Dizdarevic
 * Tests using mocking
 */
public class MockTest {
    PurchaseManager purchaseManager = new PurchaseManager();
    CustomerManager cm=new CustomerManager();
    public static final PurchaseDao purchaseDaoMock = mock(PurchaseDao.class);
    public static final CustomerDao customerDaoMock=mock(CustomerDao.class);
    public static final MovieDao movieDaoMock = mock(MovieDao.class);
    @BeforeAll
    static void setMock(){
        MockedStatic<DaoFactory> daoFactory= Mockito.mockStatic(DaoFactory.class);
        daoFactory.when(DaoFactory::purchaseDao).thenReturn(purchaseDaoMock);
        daoFactory.when(DaoFactory::movieDao).thenReturn(movieDaoMock);
        daoFactory.when(DaoFactory::customerDao).thenReturn(customerDaoMock);
    }
    @Test
      public void AlreadyRegistered(){
         Movie movie = new Movie();
         movie.setTitle("aa"); movie.setLength(30); movie.setPrice(30); movie.setGenre("com"); movie.setRelease_date(Date.valueOf(LocalDate.now()));
         movie.setMain_actor("dsdsd");
         Customer customer = new Customer();
         customer.setPw("dsadasdas"); customer.setName("a"); customer.setSurname("b"); customer.setMail("asdas"); customer.setUsername("dsadasdasd");
         Purchase purchase = new Purchase();
         purchase.setMovie(movie);
         purchase.setCustomer(customer);
         purchase.setDate_of_rent(Date.valueOf(LocalDate.now()));
         List<Purchase> list1= new ArrayList<>();
         list1.add(purchase);
         when(purchaseDaoMock.getAll()).thenReturn(list1);
         List<Purchase> list = purchaseManager.getAll();
         assertEquals(list.get(0).getCustomer().getUsername(),purchase.getCustomer().getUsername());
      }
      @Test
      public void SearchByUsernameMock(){
          String username="kenankd";
          when(customerDaoMock.searchByUsername(username)).thenReturn(new Customer("kenan","dizdarevic","kenankd","kenankd","dakdiasdiasda"));
          CustomerManager cm=new CustomerManager();
          Customer c1=cm.searchByUsername(username);
          assertEquals("kenankd",c1.getUsername());
      }
}
