package ba.unsa.etf.rpr.exceptions;

import java.sql.SQLException;

public class MovieException extends RuntimeException{
    public MovieException(String message, SQLException e){
        super(message);
    }
    public MovieException(String message){
        super(message);
    }
}
