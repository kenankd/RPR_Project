package ba.unsa.etf.rpr.domain;

import java.util.Objects;

/**
 * List of customers who bought movies
 * @author Kenan Dizdarevic
 */

public class Customer implements Idable{
    private int customer_id;
    private String name,surname;
    private String mail;
    private String address,phone_number;


    public Customer(int idcustomer, String name, String surname, String mail, String adress, String phone_number) {
        this.customer_id = idcustomer;
        this.name = name;
        this.surname = surname;
        this.mail = mail;
        this.address = adress;
        this.phone_number = phone_number;
    }

    public Customer() {
        this.customer_id = 0;
        this.name = "";
        this.surname = "";
        this.mail = "";
        this.address = "";
        this.phone_number = "";
    }
    @Override
    public int getId() {
        return customer_id;
    }
    @Override
    public void setId(int id){
        this.customer_id=id;
    }
    public void setCustomer_id(int idcustomer) {
        this.customer_id = idcustomer;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
        return getId() == customer.getId() && Objects.equals(getName(), customer.getName()) && Objects.equals(getSurname(), customer.getSurname()) && Objects.equals(getMail(), customer.getMail()) && Objects.equals(getAddress(), customer.getAddress()) && Objects.equals(getPhone_number(), customer.getPhone_number());
    }
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSurname(), getMail(), getAddress(), getPhone_number());
    }
    @Override
    public String toString() {
        return "Customer{" +
                "idcustomer=" + customer_id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", mail='" + mail + '\'' +
                ", adress='" + address + '\'' +
                ", phone_number='" + phone_number + '\'' +
                '}';
    }


}
