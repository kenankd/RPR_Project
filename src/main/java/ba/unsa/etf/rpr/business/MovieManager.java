package ba.unsa.etf.rpr.business;

import ba.unsa.etf.rpr.dao.DaoFactory;
import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.domain.Purchase;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.List;

public class MovieManager {
    public List<Movie> getAll() throws MovieException {
        return DaoFactory.movieDao().getAll();
    }
    public void delete(int id) throws MovieException {
        DaoFactory.movieDao().delete(id);
    }
    public Movie add(Movie item) throws MovieException{
        return DaoFactory.movieDao().add(item);
    }
    public Movie update(Movie item) throws MovieException{
        return DaoFactory.movieDao().update(item);
    }
    public List<Movie> searchByTitle(String title){
        return DaoFactory.movieDao().searchByTitle(title);
    }
}
