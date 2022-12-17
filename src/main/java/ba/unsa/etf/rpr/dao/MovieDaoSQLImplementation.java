package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.SingletonConnection;
import ba.unsa.etf.rpr.domain.Movie;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class MovieDaoSQLImplementation implements MovieDao {
    private Connection connection;

    public MovieDaoSQLImplementation() {
        try {
            connection= SingletonConnection.getInstance();
        } catch (RuntimeException e) {
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
        String add = "INSERT INTO Movie(movie_title,main_actor,release_date,price,length,genre_id) VALUES(?,?,?,?,?,?)";
        try{
            PreparedStatement ps=this.connection.prepareStatement(add,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,item.getTitle());
            ps.setString(2,item.getMain_actor());
            ps.setDate(3, (java.sql.Date) item.getRelease_date());
            ps.setDouble(4,item.getPrice());
            ps.setInt(5,item.getLength());
            ps.setInt(6,item.getGenre_id());
            ps.executeUpdate();
            ResultSet rs=ps.getGeneratedKeys();
            rs.next();
            item.setMovie_Id(rs.getInt(1));
            return item;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Movie update(Movie item) {
        try{
            PreparedStatement ps=connection.prepareStatement("UPDATE Movie SET movie_title=?,main_actor=?,release_date=?,price=?,length=?,genre_id=? where movie_id=?");
            ps.setString(1,item.getTitle());
            ps.setString(2,item.getMain_actor());
            ps.setDate(3, (java.sql.Date) item.getRelease_date());
            ps.setDouble(4,item.getPrice());
            ps.setInt(5,item.getLength());
            ps.setInt(6,item.getGenre_id());
            ps.setInt(7,item.getMovie_Id());
            ps.executeUpdate();
            return item;

        } catch (SQLException e) {
            e.printStackTrace();

        }
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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
            while (rs.next()) {
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

