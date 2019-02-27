package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by 29252 on 2017/7/21.
 */
@Entity
public class Cart {
    private int orderId;
    private Integer customerId;
    private Integer artworkId;
    private String dateCreate;
    private String artworkTitle;

    public Cart(){};

    public Cart(int orderId) {this.orderId = orderId;}

    public Cart(Integer customerId, Integer artworkId, String dateCreate, String artworkTitle) {
        this.customerId = customerId;
        this.artworkId = artworkId;
        this.dateCreate = dateCreate;
        this.artworkTitle = artworkTitle;
    }

    public Cart(int orderId, Integer customerId, Integer artworkId, String dateCreate, String artworkTitle) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.artworkId = artworkId;
        this.dateCreate = dateCreate;
        this.artworkTitle = artworkTitle;
    }

    @Id
    @Column(name = "OrderId")
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "CustomerId")
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    @Basic
    @Column(name = "ArtworkId")
    public Integer getArtworkId() {
        return artworkId;
    }

    public void setArtworkId(Integer artworkId) {
        this.artworkId = artworkId;
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
    @Column(name = "ArtworkTitle")
    public String getArtworkTitle() {
        return artworkTitle;
    }

    public void setArtworkTitle(String artworkTitle) {
        this.artworkTitle = artworkTitle;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cart cart = (Cart) o;

        if (orderId != cart.orderId) return false;
        if (customerId != null ? !customerId.equals(cart.customerId) : cart.customerId != null) return false;
        if (artworkId != null ? !artworkId.equals(cart.artworkId) : cart.artworkId != null) return false;
        if (dateCreate != null ? !dateCreate.equals(cart.dateCreate) : cart.dateCreate != null) return false;
        if (artworkTitle != null ? !artworkTitle.equals(cart.artworkTitle) : cart.artworkTitle != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderId;
        result = 31 * result + (customerId != null ? customerId.hashCode() : 0);
        result = 31 * result + (artworkId != null ? artworkId.hashCode() : 0);
        result = 31 * result + (dateCreate != null ? dateCreate.hashCode() : 0);
        result = 31 * result + (artworkTitle != null ? artworkTitle.hashCode() : 0);
        return result;
    }
}
