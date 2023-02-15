package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Movie;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.util.Date;
import java.util.List;

/**
 * Dao interface for domain Movie
 * @author Kenan Dizdarevic
 */
public interface MovieDao extends Dao<Movie> {
    /**
     * Returns all movies with given title
     * @param title search based on this parameter
     * @return list of movies
     */
    List<Movie> searchByTitle(String title) throws MovieException;

    /**
     * Returns all movies with given main actor
     * @param main_actor search based on this parameter
     * @return list of movies
     */
    List<Movie> searchByMainActor(String main_actor)throws MovieException;
    /**
     * Returns all movies released after given date
     * @param date search based on this parameter
     * @return list of movies
     */
    List<Movie> getMoviesReleasedAfter(Date date) throws MovieException;

    /**
     * Returns all movies shorter than given number of minutes
     * @param length movie length in minutes
     * @return list of movies
     */
    List<Movie> getMoviesShorterThan(int length)throws MovieException;
    /**
     * Returns all movies longer than given number of minutes
     * @param length movie length in minutes
     * @return list of movies
     */
    List<Movie> getMoviesLongerThan(int length)throws MovieException;
    /**
     * Returns all movies cheaper than given price
     * @param price price of movie
     * @return list of movies
     */
    List<Movie> getMoviesCheaperThan(double price)throws MovieException;
    /**
     * Returns all movies of given genre
     * @param genre price of movie
     * @return list of movies
     */


}
