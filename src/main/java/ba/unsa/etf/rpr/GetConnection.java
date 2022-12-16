package ba.unsa.etf.rpr;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class GetConnection {
    private static Connection connection;
    public static Connection get(){
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
                throw new RuntimeException(e);
            }
        }
        else return connection;
    }
}
