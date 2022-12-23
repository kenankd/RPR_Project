package ba.unsa.etf.rpr.dao;

import ba.unsa.etf.rpr.domain.Genre;
import ba.unsa.etf.rpr.exceptions.MovieException;

import java.sql.*;
import java.util.Map;
import java.util.TreeMap;

public class GenreDaoSQLImplementation extends AbstractDao<Genre> implements GenreDao{

    public GenreDaoSQLImplementation() {
        super("Genre");
    }

    @Override
    public Genre row2object(ResultSet rs) throws MovieException {
        try{
            Genre g=new Genre();
            g.setGenre_name(rs.getString("genre_name"));
            g.setId(rs.getInt("id"));
            return g;
        } catch (SQLException e) {
            throw new MovieException(e.getMessage(),e);
        }
    }

    @Override
    public Map<String, Object> object2row(Genre object) {
        Map<String, Object> map = new TreeMap<>();
        map.put("id", object.getId());
        map.put("genre_name", object.getGenre_name());
        return map;
    }


}
