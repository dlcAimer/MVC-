package entity;

import javax.persistence.*;

/**
 * Created by 29252 on 2017/7/20.
 */
@Entity
@Table(name = "typesstatuscodes", schema = "art")
public class Typesstatuscodes {
    private int statusId;
    private String status;

    @Id
    @Column(name = "StatusID")
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "Status")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typesstatuscodes that = (Typesstatuscodes) o;

        if (statusId != that.statusId) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
