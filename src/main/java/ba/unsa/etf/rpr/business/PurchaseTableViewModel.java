package ba.unsa.etf.rpr.business;

import java.util.Date;

public class PurchaseTableViewModel {
    private String title,main_actor,genre;
     private Date purchase_date;
     private double price;

    public PurchaseTableViewModel(String title, String main_actor, String genre, double price, Date date) {
        this.title=title;
        this.main_actor=main_actor;
        this.genre=genre;
        this.price=price;
        this.purchase_date=date;
    }

    public PurchaseTableViewModel() {

    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMain_actor() {
        return main_actor;
    }

    public void setMain_actor(String main_actor) {
        this.main_actor = main_actor;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Date getPurchase_date() {
        return purchase_date;
    }

    public void setPurchase_date(Date purchase_date) {
        this.purchase_date = purchase_date;
    }


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
