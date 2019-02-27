package entity;

import javax.persistence.*;

/**
 * Created by 29252 on 2017/7/20.
 */
@Entity
@Table(name = "orderdetails", schema = "art", catalog = "")
public class Orderdetails {
    private int orderDetailsId;
    private Integer artWorkId;
    private Integer orderId;
    private Integer frameId;
    private Integer mattId;
    private Integer glassId;

    @Id
    @Column(name = "OrderDetailsID")
    public int getOrderDetailsId() {
        return orderDetailsId;
    }

    public void setOrderDetailsId(int orderDetailsId) {
        this.orderDetailsId = orderDetailsId;
    }

    @Basic
    @Column(name = "ArtWorkID")
    public Integer getArtWorkId() {
        return artWorkId;
    }

    public void setArtWorkId(Integer artWorkId) {
        this.artWorkId = artWorkId;
    }

    @Basic
    @Column(name = "OrderID")
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "FrameID")
    public Integer getFrameId() {
        return frameId;
    }

    public void setFrameId(Integer frameId) {
        this.frameId = frameId;
    }

    @Basic
    @Column(name = "MattID")
    public Integer getMattId() {
        return mattId;
    }

    public void setMattId(Integer mattId) {
        this.mattId = mattId;
    }

    @Basic
    @Column(name = "GlassID")
    public Integer getGlassId() {
        return glassId;
    }

    public void setGlassId(Integer glassId) {
        this.glassId = glassId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Orderdetails that = (Orderdetails) o;

        if (orderDetailsId != that.orderDetailsId) return false;
        if (artWorkId != null ? !artWorkId.equals(that.artWorkId) : that.artWorkId != null) return false;
        if (orderId != null ? !orderId.equals(that.orderId) : that.orderId != null) return false;
        if (frameId != null ? !frameId.equals(that.frameId) : that.frameId != null) return false;
        if (mattId != null ? !mattId.equals(that.mattId) : that.mattId != null) return false;
        if (glassId != null ? !glassId.equals(that.glassId) : that.glassId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = orderDetailsId;
        result = 31 * result + (artWorkId != null ? artWorkId.hashCode() : 0);
        result = 31 * result + (orderId != null ? orderId.hashCode() : 0);
        result = 31 * result + (frameId != null ? frameId.hashCode() : 0);
        result = 31 * result + (mattId != null ? mattId.hashCode() : 0);
        result = 31 * result + (glassId != null ? glassId.hashCode() : 0);
        return result;
    }
}
