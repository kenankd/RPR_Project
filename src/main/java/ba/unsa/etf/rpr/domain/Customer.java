package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * List of customers who bought movies
 * @author Kenan Dizdarevic
 */

public class Customer implements Idable{
    private int id;
    private String name,surname;
    private String mail,pw,username;


    public Customer(int id, String name, String surname, String mail, String pw, String username) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.pw = pw;
        this.username = username;
    }

    public Customer() {
        this.id = 0;
        this.name = "";
        this.surname = "";
        this.mail = "";
        this.pw = "";
        this.username = "";
    }
    @Override
    public int getId() {
        return id;
    }
    @Override
    public void setId(int id){
        this.id=id;
    }
    public void setCustomer_id(int idcustomer) {
        this.id = idcustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getId() == customer.getId() && Objects.equals(getName(), customer.getName()) && Objects.equals(getSurname(), customer.getSurname()) && Objects.equals(getMail(), customer.getMail()) && Objects.equals(getPw(), customer.getPw()) && Objects.equals(getUsername(), customer.getUsername());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getMail(), getPw(), getUsername());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", pw='" + pw + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
