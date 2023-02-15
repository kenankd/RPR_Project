package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Customer;

/**
 * Factory for all Dao implementations
 * @author Kenan Dizdarevic
 */
public class DaoFactory {
    private static final CustomerDao customerDao=new CustomerDaoSQLImplementation();
    private static final MovieDao movieDao=new MovieDaoSQLImplementation();

    private static final PurchaseDao purchaseDao=new PurchaseDaoSQLImplementation();
    private DaoFactory(){}
    public static CustomerDao customerDao(){
        return customerDao;
    }
    public static MovieDao movieDao(){
        return movieDao;
    }
    public static PurchaseDao purchaseDao(){
        return purchaseDao;
    }

}
