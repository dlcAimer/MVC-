package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 29252 on 2017/7/21.
 */
@Entity
public class Onesorder {
    private int onesorderId;
    private Integer cutomerId;
    private Integer artWorkId;
    private String artWorkTitle;
    private String dateCreate;
    private String dateCompleted;

    public Onesorder() {
    }

    public Onesorder(int onesorderId, Integer customerId, Integer artWorkId, String artWorkTitle, String dateCreate, String dateCompleted) {
        this.onesorderId = onesorderId;
        this.cutomerId = customerId;
        this.artWorkId = artWorkId;
        this.artWorkTitle = artWorkTitle;
        this.dateCreate = dateCreate;
        this.dateCompleted = dateCompleted;
    }

    public Onesorder(int customerId, int artWorkId, String title, String dateCreate, String dateCompleted) {
        this.cutomerId = customerId;
        this.artWorkId = artWorkId;
        this.artWorkTitle = title;
        this.dateCreate = dateCreate;
        this.dateCompleted = dateCompleted;
    }

    @Id
    @Column(name = "OnesorderId")
    public int getOnesorderId() {
        return onesorderId;
    }

    public void setOnesorderId(int onesorderId) {
        this.onesorderId = onesorderId;
    }

    @Basic
    @Column(name = "CustomerId")
    public Integer getCustomerId() {
        return cutomerId;
    }

    public void setCustomerId(Integer cutomerId) {
        this.cutomerId = cutomerId;
    }

    @Basic
    @Column(name = "ArtWorkId")
    public Integer getArtWorkId() {
        return artWorkId;
    }

    public void setArtWorkId(Integer artworkId) {
        this.artWorkId = artworkId;
    }

    @Basic
    @Column(name = "ArtWorkTitle")
    public String getArtWorkTitle() {
        return artWorkTitle;
    }

    public void setArtWorkTitle(String artWorkTitle) {
        this.artWorkTitle = artWorkTitle;
    }

    @Basic
    @Column(name = "DateCreate")
    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    @Basic
    @Column(name = "DateCompleted")
    public String getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(String dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Onesorder onesorder = (Onesorder) o;

        if (onesorderId != onesorder.onesorderId) return false;
        if (cutomerId != null ? !cutomerId.equals(onesorder.cutomerId) : onesorder.cutomerId != null) return false;
        if (artWorkId != null ? !artWorkId.equals(onesorder.artWorkId) : onesorder.artWorkId != null) return false;
        if (artWorkTitle != null ? !artWorkTitle.equals(onesorder.artWorkTitle) : onesorder.artWorkTitle != null)
            return false;
        if (dateCreate != null ? !dateCreate.equals(onesorder.dateCreate) : onesorder.dateCreate != null) return false;
        if (dateCompleted != null ? !dateCompleted.equals(onesorder.dateCompleted) : onesorder.dateCompleted != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = onesorderId;
        result = 31 * result + (cutomerId != null ? cutomerId.hashCode() : 0);
        result = 31 * result + (artWorkId != null ? artWorkId.hashCode() : 0);
        result = 31 * result + (artWorkTitle != null ? artWorkTitle.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (dateCompleted != null ? dateCompleted.hashCode() : 0);
        return result;
    }
}
