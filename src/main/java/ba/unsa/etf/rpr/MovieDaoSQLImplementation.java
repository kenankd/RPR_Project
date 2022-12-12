package ba.unsa.etf.rpr;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MovieDaoSQLImplementation implements MovieDao {
    private Connection connection;

    public MovieDaoSQLImplementation() {
        try {
            connection = DriverManager.getConnection("jdbc:mysql://sq7.freemysqlhosting.net:3306/sql7584050", "sql7584050", "mVSKqJ5z1H");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Movie getById(int id) {
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where movie_id _= ?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                rs.close();
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Movie add(Movie item) {
        return null;
    }

    @Override
    public Movie update(Movie item) {
        return null;
    }

    @Override
    public void delete(int id) {
        String delete = "DELETE FROM Movie WHERE movie_id = ?";
        try {
            PreparedStatement s = connection.prepareStatement(delete);
            s.setInt(1, id);
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Movie> getAll() {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie");
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where movie_title = ?");
            s.setString(1, title);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Movie> searchByMainActor(String main_actor) {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where main_actor = ?");
            s.setString(1, main_actor);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Movie> getMoviesReleasedAfter(Date date) {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where release_date > ?");
            s.setDate(1, (java.sql.Date) date);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Movie> getMoviesShorterThan(int length) {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where length < ?");
            s.setInt(1, length);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Movie> getMoviesLongerThan(int length) {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where length > ?");
            s.setInt(1, length);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Movie> getMoviesCheaperThan(double price) {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where price<= ?");
            s.setDouble(1, price);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    @Override
    public List<Movie> searchByGenre(String genre) {
        List<Movie> lista = new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Movie where genre = ?");
            s.setString(1, genre);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Movie c = new Movie();
                c.setMovie_Id(rs.getInt("movie_id"));
                c.setTitle(rs.getString("movie_title"));
                c.setLength(rs.getInt("length"));
                c.setGenre_id(rs.getInt("genre_id"));
                c.setPrice(rs.getDouble("price"));
                c.setMain_actor(rs.getString("main_actor"));
                c.setRelease_date(rs.getDate("release_date"));
                lista.add(c);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }
}

