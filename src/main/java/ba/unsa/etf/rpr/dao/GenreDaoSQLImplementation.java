package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.SingletonConnection;
import ba.unsa.etf.rpr.domain.Genre;
import ba.unsa.etf.rpr.exceptions.ConnectionException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GenreDaoSQLImplementation implements GenreDao{
    private Connection connection;
    public GenreDaoSQLImplementation() {
        try {
            connection= SingletonConnection.getInstance();
        } catch (ConnectionException e) {
            e.printStackTrace();
        }
    }
    @Override
    public Genre getById(int id) {
        try {
            PreparedStatement s = connection.prepareStatement("select * from Genre where genre_id _= ?");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if (rs.next()) {
                Genre c = new Genre();
                c.setGenre_id(rs.getInt("genre_id"));
                c.setGenre_name(rs.getString("genre_name"));
                rs.close();
                return c;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Genre add(Genre item) {
        return null;
    }

    @Override
    public Genre update(Genre item) {
        return null;
    }

    @Override
    public void delete(int id) {
        String delete = "DELETE FROM Genre WHERE genre_id = ?";
        try {
            PreparedStatement s = connection.prepareStatement(delete);
            s.setInt(1, id);
            s.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Genre> getAll() {
        List<Genre> lista=new ArrayList<>();
        try {
            PreparedStatement s = connection.prepareStatement("select * from Genre");
            ResultSet rs = s.executeQuery();
            while (rs.next()) {
                Genre c = new Genre();
                c.setGenre_id(rs.getInt("genre_id"));
                c.setGenre_name(rs.getString("genre_name"));
                lista.add(c);
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
