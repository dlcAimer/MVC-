package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Timestamp;

/**
 * Created by 29252 on 2017/7/20.
 */
@Entity
public class CustomerLogon {
    private int customerId;
    private String userName;
    private String pass;
    private Integer state;
    private Timestamp dateJoined;
    private Timestamp dateLastModified;

    public CustomerLogon() {}

    public CustomerLogon(String userName, String pass) {
        this.pass = pass;
        this.userName = userName;
        this.state = 0;
        this.dateJoined = new Timestamp(System.currentTimeMillis());
        this.dateLastModified = new Timestamp(System.currentTimeMillis());
    }

    public CustomerLogon(int id, String userName, int state, Timestamp dateJoined, Timestamp dateLastModified) {
        this.pass = null;
        this.customerId = id;
        this.userName = userName;
        this.state = state;
        this.dateJoined = dateJoined;
        this.dateLastModified = dateLastModified;
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
    @Column(name = "UserName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "Pass")
    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Basic
    @Column(name = "State")
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Basic
    @Column(name = "DateJoined")
    public Timestamp getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Timestamp dateJoined) {
        this.dateJoined = dateJoined;
    }

    @Basic
    @Column(name = "DateLastModified")
    public Timestamp getDateLastModified() {
        return dateLastModified;
    }

    public void setDateLastModified(Timestamp dateLastModified) {
        this.dateLastModified = dateLastModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerLogon that = (CustomerLogon) o;

        if (customerId != that.customerId) return false;
        if (userName != null ? !userName.equals(that.userName) : that.userName != null) return false;
        if (pass != null ? !pass.equals(that.pass) : that.pass != null) return false;
        if (state != null ? !state.equals(that.state) : that.state != null) return false;
        if (dateJoined != null ? !dateJoined.equals(that.dateJoined) : that.dateJoined != null) return false;
        if (dateLastModified != null ? !dateLastModified.equals(that.dateLastModified) : that.dateLastModified != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = customerId;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (pass != null ? pass.hashCode() : 0);
        result = 31 * result + (state != null ? state.hashCode() : 0);
        result = 31 * result + (dateJoined != null ? dateJoined.hashCode() : 0);
        result = 31 * result + (dateLastModified != null ? dateLastModified.hashCode() : 0);
        return result;
    }
}
