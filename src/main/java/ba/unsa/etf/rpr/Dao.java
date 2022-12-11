package ba.unsa.etf.rpr;

import java.util.List;

/**
 * Root interface for all DAO classes
 * @author Kenan Dizdarevic
 */
public interface Dao<type> {
    /**
     * gets entity from database based on parameter ID
     * @param id primary key of entity
     * @return entity from database
     */
    type getById(int id);

    /**
     * adds entity in database
     * @param item entity for saving in database
     * @return saved item with id
     */
    type add(type item);

    /**
     * updates entity in database based on id
     * @param item row to be updated
     * @return updated version of row
     */
    type update(type item);

    /**
     * delete of item in database based on parameter id
     * @param id primary key
     */
    void delete(int id);

    /**
     * lists all entities from database
     * @return list of entities from database
     */
    List<type> getAll();

}
