package ba.unsa.etf.rpr;

import ba.unsa.etf.rpr.exceptions.ConnectionException;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

/**
 * Class for establishing connection with server, based on singleton design pattern
 * @author Kenan Dizdarevic
 */
public class SingletonConnection {
    private static final SingletonConnection instance=new SingletonConnection();
    private static Connection connection;
    private SingletonConnection(){}

    /**
     * establishes connection if it's null, if it's already established just returns it
     * @return connection
     */
    public static Connection getInstance(){
        if(connection==null){
            try{
                FileReader fr=new FileReader("src/main/resources/properties");
                Properties p=new Properties();
                p.load(fr);
                String url=p.getProperty("url");
                String user=p.getProperty("user");
                String pw=p.getProperty("pw");
                Class.forName("com.mysql.cj.jdbc.Driver");
                connection= DriverManager.getConnection(url,user,pw);
                return connection;
            } catch (Exception e) {
                throw new ConnectionException("Failed to establish connection");
            }
        }
        else return connection;
    }
}
