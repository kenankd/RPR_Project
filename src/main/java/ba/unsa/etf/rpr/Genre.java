package ba.unsa.etf.rpr;

import java.util.Objects;

public class Genre {
    private int genre_id;
    private String genre_name;

    public Genre(int genre_id, String genre_name) {
        this.genre_id = genre_id;
        this.genre_name = genre_name;
    }

    public int getGenre_id() {
        return genre_id;
    }

    public void setGenre_id(int genre_id) {
        this.genre_id = genre_id;
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
        return getGenre_id() == genre.getGenre_id() && Objects.equals(getGenre_name(), genre.getGenre_name());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getGenre_id(), getGenre_name());
    }

    @Override
    public String toString() {
        return "Genre{" +
                "genre_id=" + genre_id +
                ", genre_name='" + genre_name + '\'' +
                '}';
    }
}
