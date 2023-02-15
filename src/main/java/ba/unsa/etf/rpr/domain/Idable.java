package ba.unsa.etf.rpr.domain;

/**
 * interface that forces all domain classes to have ID field
 * @author Kenan Dizdarevic
 */
public interface Idable {
    void setId(int id);

    int getId();
}
