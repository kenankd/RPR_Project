package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * List of all possible genres for movies
 *
 * @author Kenan Dizdarevic
 */
public class Genre implements Idable{
    private int id;
    private String genre_name;

    public Genre(int genre_id, String genre_name) {
        this.id = genre_id;
        this.genre_name = genre_name;
    }

    public Genre() {
        this.id = 0;
        this.genre_name = "";
    }
    public String getGenre_name() {
        return genre_name;
    }

    public void setGenre_name(String genre_name) {
        this.genre_name = genre_name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Genre)) return false;
        Genre genre = (Genre) o;
        return getId() == genre.getId() && Objects.equals(getGenre_name(), genre.getGenre_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getGenre_name());
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + id +
                ", genre_name='" + genre_name + '\'' +
                '}';
    }

    @Override
    public void setId(int id) {
        this.id=id;
    }

    @Override
    public int getId() {
        return id;
    }
}
