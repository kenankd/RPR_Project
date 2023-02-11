package ba.unsa.etf.rpr.domain;

import java.util.Date;
import java.util.Objects;

/**
 * Class that holds all purchases of movies
 */
public class Purchase implements Idable{
    private int id;
    private Movie movie;
    private Customer customer;
    private Date date_of_rent;

    public Purchase( Movie movie, Customer customer, Date date_of_rent) {
        this.movie = movie;
        this.customer = customer;
        this.date_of_rent = date_of_rent;
    }

    public Purchase() {

    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getDate_of_rent() {
        return date_of_rent;
    }

    public void setDate_of_rent(Date date_of_rent) {
        this.date_of_rent = date_of_rent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return getId() == purchase.getId() && Objects.equals(getMovie(), purchase.getMovie()) && Objects.equals(getCustomer(), purchase.getCustomer()) && Objects.equals(getDate_of_rent(), purchase.getDate_of_rent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getMovie(), getCustomer(), getDate_of_rent());
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "id=" + id +
                ", movie=" + movie +
                ", customer=" + customer +
                ", date_of_rent=" + date_of_rent +
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
