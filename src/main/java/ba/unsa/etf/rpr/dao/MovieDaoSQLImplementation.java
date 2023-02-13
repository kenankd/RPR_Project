package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.sql.*;
import java.sql.Date;
import java.util.*;

public class MovieDaoSQLImplementation extends AbstractDao<Movie> implements MovieDao {

    public MovieDaoSQLImplementation() {
        super("Movie");
    }

    @Override
    public Movie row2object(ResultSet rs) throws MovieException {
        try {
            Movie c = new Movie();
            c.setId(rs.getInt("id"));
            c.setTitle(rs.getString("title"));
            c.setLength(rs.getInt("length"));
            c.setPrice(rs.getDouble("price"));
            c.setMain_actor(rs.getString("main_actor"));
            c.setRelease_date(rs.getDate("release_date"));
            c.setGenre(rs.getString("genre"));
            return c;
        } catch (SQLException e) {
            throw new MovieException(e.getMessage(), e);
        }
    }

    @Override
    public Map<String, Object> object2row(Movie object) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", object.getId());
        map.put("title", object.getTitle());
        map.put("release_date", object.getRelease_date());
        map.put("price", object.getPrice());
        map.put("length", object.getLength());
        map.put("main_actor", object.getMain_actor());
        map.put("genre",object.getGenre());
        return map;
    }


    @Override
    public List<Movie> searchByTitle(String title) throws MovieException {
        return executeQuery("select * from Movie where title LIKE concat('%',?,'%')",new Object[]{title});

    }

    @Override
    public List<Movie> searchByMainActor(String main_actor) throws MovieException {
        return executeQuery("select * from Movie where main_actor LIKE concat('%',?,'%')",new Object[]{main_actor});

    }

    @Override
    public List<Movie> getMoviesReleasedAfter(java.util.Date date) throws MovieException {
        return executeQuery("select * from Movie where release_date > ?",new Object[]{date});
    }

    @Override
    public List<Movie> getMoviesShorterThan(int length) throws MovieException {
        return executeQuery("select * from Movie where length <= ?",new Object[]{length});
    }

    @Override
    public List<Movie> getMoviesLongerThan(int length) throws MovieException {
        return executeQuery("select * from Movie where length >= ?",new Object[]{length});
    }

    @Override
    public List<Movie> getMoviesCheaperThan(double price) throws MovieException {
        return executeQuery("select * from Movie where price <= ?",new Object[]{price});

    }


}

