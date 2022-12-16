package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class that holds all avalaible movies
 */
public class Movie {

    private int movie_id;
    private String title;
    private Date release_date;
    private String main_actor;
    private double price;
    private int length;
    private int genre_id;
    public Movie(int movie_id, String title, Date release_date, String main_actor, double price, int length, int genre_id) {
        this.movie_id = movie_id;
        this.title = title;
        this.release_date = release_date;
        this.main_actor = main_actor;
        this.price = price;
        this.length = length;
        this.genre_id = genre_id;
    }

    public Movie() {
        this.movie_id = 0;
        this.title = "";
        this.release_date = new Date();
        this.main_actor = "";
        this.price = 0;
        this.length = 0;
        this.genre_id = 0;
    }

    public int getMovie_Id() {
        return movie_id;
    }

    public void setMovie_Id(int id) {
        this.movie_id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getRelease_date() {
        return release_date;
    }

    public void setRelease_date(Date release_date) {
        this.release_date = release_date;
    }

    public String getMain_actor() {
        return main_actor;
    }

    public void setMain_actor(String main_actor) {
        this.main_actor = main_actor;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Movie)) return false;
        Movie movie = (Movie) o;
        return getMovie_Id() == movie.getMovie_Id() && getTitle() == movie.getTitle() && Double.compare(movie.getPrice(), getPrice()) == 0 && getLength() == movie.getLength() && getGenre_id() == movie.getGenre_id() && Objects.equals(getRelease_date(), movie.getRelease_date()) && Objects.equals(getMain_actor(), movie.getMain_actor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMovie_Id(), getTitle(), getRelease_date(), getMain_actor(), getPrice(), getLength(), getGenre_id());
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + movie_id +
                ", title=" + title +
                ", release_date=" + release_date +
                ", main_actor='" + main_actor + '\'' +
                ", price=" + price +
                ", length=" + length +
                ", genre_id=" + genre_id +
                '}';
    }
}
