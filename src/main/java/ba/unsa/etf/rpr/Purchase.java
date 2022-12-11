package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.Objects;

/**
 * Class that holds all purchases of movies
 */
public class Purchase {
    private int rent_id,movie_id,customer_id;
    private Date date_of_rent;

    public Purchase(int rent_id, int movie_id, int customer_id, Date date_of_rent) {
        this.rent_id = rent_id;
        this.movie_id = movie_id;
        this.customer_id = customer_id;
        this.date_of_rent = date_of_rent;
    }

    public Purchase() {
        rent_id=0;
        movie_id=0;
        customer_id=0;
        date_of_rent=new Date();
    }

    public int getRent_id() {
        return rent_id;
    }

    public void setRent_id(int rent_id) {
        this.rent_id = rent_id;
    }

    public int getMovie_id() {
        return movie_id;
    }

    public void setMovie_id(int movie_id) {
        this.movie_id = movie_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
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
        return getRent_id() == purchase.getRent_id() && getMovie_id() == purchase.getMovie_id() && getCustomer_id() == purchase.getCustomer_id() && Objects.equals(getDate_of_rent(), purchase.getDate_of_rent());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRent_id(), getMovie_id(), getCustomer_id(), getDate_of_rent());
    }

    @Override
    public String toString() {
        return "Rent{" +
                "rent_id=" + rent_id +
                ", movie_id=" + movie_id +
                ", customer_id=" + customer_id +
                ", date_of_rent=" + date_of_rent +
                '}';
    }
}
