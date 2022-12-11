package ba.unsa.etf.rpr;

import java.util.Objects;

/**
 * List of customers who bought movies
 * @author Kenan Dizdarevic
 */

public class Customer {
    private int idcustomer;
    private String name,surname;
    private String mail;
    private String adress,phone_number;

    public Customer(int idcustomer, String name, String surname, String mail, String adress, String phone_number) {
        this.idcustomer = idcustomer;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.adress = adress;
        this.phone_number = phone_number;
    }

    public int getIdcustomer() {
        return idcustomer;
    }

    public void setIdcustomer(int idcustomer) {
        this.idcustomer = idcustomer;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Customer)) return false;
        Customer customer = (Customer) o;
        return getIdcustomer() == customer.getIdcustomer() && Objects.equals(getName(), customer.getName()) && Objects.equals(getSurname(), customer.getSurname()) && Objects.equals(getMail(), customer.getMail()) && Objects.equals(getAdress(), customer.getAdress()) && Objects.equals(getPhone_number(), customer.getPhone_number());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getIdcustomer(), getName(), getSurname(), getMail(), getAdress(), getPhone_number());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "idcustomer=" + idcustomer +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", adress='" + adress + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }
}
