package ba.unsa.etf.rpr;

import java.util.Date;
import java.util.Objects;

public class Rent {
    private int rent_id,movie_id,customer_id;
    private Date date_of_rent;

    public Rent(int rent_id, int movie_id, int customer_id, Date date_of_rent) {
        this.rent_id = rent_id;
        this.movie_id = movie_id;
        this.customer_id = customer_id;
        this.date_of_rent = date_of_rent;
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
        if (!(o instanceof Rent)) return false;
        Rent rent = (Rent) o;
        return getRent_id() == rent.getRent_id() && getMovie_id() == rent.getMovie_id() && getCustomer_id() == rent.getCustomer_id() && Objects.equals(getDate_of_rent(), rent.getDate_of_rent());
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
