package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.dao.AbstractDao;
import ba.unsa.etf.rpr.dao.CustomerDaoSQLImplementation;
import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.dao.MovieDaoSQLImplementation;
import ba.unsa.etf.rpr.domain.Customer;
import ba.unsa.etf.rpr.domain.Movie;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        CustomerDaoSQLImplementation c = new CustomerDaoSQLImplementation();
        Customer cc = new Customer();
        cc.setUsername("kenankd");
        cc.setPw("aaa");
        cc.setMail("ss");
        cc.setSurname("diz");
        cc.setName("ken");
        cc.setId(1);
        List<Customer> a=c.searchByName("ke");
        System.out.println(a.size()+ ","+a.get(0));



    }
}

