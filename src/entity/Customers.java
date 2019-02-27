package entity;

import javax.persistence.*;

/**
 * Created by 29252 on 2017/7/20.
 */
@Entity
public class Customers {
    private int customerId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private String region;
    private String country;
    private String postal;
    private String phone;
    private String email;
    private String privacy;



    private String username;

    @OneToOne
    private CustomerLogon customerLogon;

    public Customers(){};

    public Customers(int customerID, String firstName, String lastName, String address, String city, String region, String country, String postal, String phone, String email, String privacy){}

    public Customers(int customerId) {
        this.customerId = customerId;
    }

    public Customers(int customerId, String email) {
        this.customerId = customerId;
        this.email = email;
    }

    public Customers(int customerId, String email, String username) {
        this.customerId = customerId;
        this.email = email;
        this.username = username;
    }

    public Customers(int customerId, String firstName, String lastName, String address,
                     String city, String region, String country, String postal,
                     String phone, String email, String privacy, String username) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.region = region;
        this.country = country;
        this.postal = postal;
        this.phone = phone;
        this.email = email;
        this.privacy = privacy;
        this.username = username;
    }

    @Id
    @Column(name = "CustomerID")
    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "FirstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "LastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "Address")
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Basic
    @Column(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "Region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "Postal")
    public String getPostal() {
        return postal;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    @Basic
    @Column(name = "Phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Privacy")
    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customers customers = (Customers) o;

        if (customerId != customers.customerId) return false;
        if (firstName != null ? !firstName.equals(customers.firstName) : customers.firstName != null) return false;
        if (lastName != null ? !lastName.equals(customers.lastName) : customers.lastName != null) return false;
        if (address != null ? !address.equals(customers.address) : customers.address != null) return false;
        if (city != null ? !city.equals(customers.city) : customers.city != null) return false;
        if (region != null ? !region.equals(customers.region) : customers.region != null) return false;
        if (country != null ? !country.equals(customers.country) : customers.country != null) return false;
        if (postal != null ? !postal.equals(customers.postal) : customers.postal != null) return false;
        if (phone != null ? !phone.equals(customers.phone) : customers.phone != null) return false;
        if (email != null ? !email.equals(customers.email) : customers.email != null) return false;
        if (privacy != null ? !privacy.equals(customers.privacy) : customers.privacy != null) return false;
        if (username != null ? !username.equals(customers.username) : customers.username != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (region != null ? region.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (postal != null ? postal.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (privacy != null ? privacy.hashCode() : 0);
        result = 31 * result + (username != null ? username.hashCode() : 0);

        return result;
    }

    public CustomerLogon getCustomerLogon() {
        return customerLogon;
    }

    public void setCustomerLogon(CustomerLogon customerLogon) {
        this.customerLogon = customerLogon;
    }
}
