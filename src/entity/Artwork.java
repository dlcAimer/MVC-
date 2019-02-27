package entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * Created by 29252 on 2017/7/20.
 */
@Entity
public class Artwork {
    private int artWorkId;
    private Integer artistId;
    private String imageFileName;
    private String title;
    private String description;
    private String excerpt;
    private Integer artWorkType;
    private Integer yearOfWork;
    private Integer width;
    private Integer height;
    private String medium;
    private String originalHome;
    private Integer galleryId;
    private BigDecimal cost;
    private BigDecimal msrp;
    private String artWorkLink;
    private String googleLink;
    private Integer sell;
    private Integer heat;
    private String subjects;

    public Artwork(){};

    public Artwork(int artWorkId) { this.artWorkId = artWorkId; }

    public Artwork(int artWorkId, Integer artistId, String imageFileName, String title, String description, String excerpt,
                   Integer artWorkType, Integer yearOfWork, Integer width, Integer height, String medium, String originalHome,
                   Integer galleryId, BigDecimal cost, BigDecimal msrp, String artWorkLink, String googleLink, Integer sell, Integer heat){
        this.artWorkId = artWorkId;
        this.artistId = artistId;
        this.imageFileName = imageFileName;
        this.title = title;
        this.description = description;
        this.excerpt = excerpt;
        this.artWorkType = artWorkType;
        this.yearOfWork = yearOfWork;
        this.width = width;
        this.height = height;
        this.medium = medium;
        this.originalHome = originalHome;
        this.galleryId = galleryId;
        this.cost = cost;
        this.msrp = msrp;
        this.artWorkLink = artWorkLink;
        this.googleLink  =googleLink;
        this.sell = sell;
        this.heat = heat;
    }

    public Artwork(int artWorkId, Integer artistId, String imageFileName, String title, String description, String excerpt, Integer artWorkType, Integer yearOfWork, Integer width, Integer height, String medium, String originalHome, Integer galleryId, BigDecimal cost, BigDecimal msrp, String artWorkLink, String googleLink, Integer sell, Integer heat, String subjects) {
        this.artWorkId = artWorkId;
        this.artistId = artistId;
        this.imageFileName = imageFileName;
        this.title = title;
        this.description = description;
        this.excerpt = excerpt;
        this.artWorkType = artWorkType;
        this.yearOfWork = yearOfWork;
        this.width = width;
        this.height = height;
        this.medium = medium;
        this.originalHome = originalHome;
        this.galleryId = galleryId;
        this.cost = cost;
        this.msrp = msrp;
        this.artWorkLink = artWorkLink;
        this.googleLink = googleLink;
        this.sell = sell;
        this.heat = heat;
        this.subjects = subjects;
    }

    @Id
    @Column(name = "ArtWorkID")
    public int getArtWorkId() {
        return artWorkId;
    }

    public void setArtWorkId(int artWorkId) {
        this.artWorkId = artWorkId;
    }

    @Basic
    @Column(name = "ArtistID")
    public Integer getArtistId() {
        return artistId;
    }

    public void setArtistId(Integer artistId) {
        this.artistId = artistId;
    }

    @Basic
    @Column(name = "ImageFileName")
    public String getImageFileName() {
        return imageFileName;
    }

    public void setImageFileName(String imageFileName) {
        this.imageFileName = imageFileName;
    }

    @Basic
    @Column(name = "Title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "Description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "Excerpt")
    public String getExcerpt() {
        return excerpt;
    }

    public void setExcerpt(String excerpt) {
        this.excerpt = excerpt;
    }

    @Basic
    @Column(name = "ArtWorkType")
    public Integer getArtWorkType() {
        return artWorkType;
    }

    public void setArtWorkType(Integer artWorkType) {
        this.artWorkType = artWorkType;
    }

    @Basic
    @Column(name = "YearOfWork")
    public Integer getYearOfWork() {
        return yearOfWork;
    }

    public void setYearOfWork(Integer yearOfWork) {
        this.yearOfWork = yearOfWork;
    }

    @Basic
    @Column(name = "Width")
    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    @Basic
    @Column(name = "Height")
    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    @Basic
    @Column(name = "Medium")
    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    @Basic
    @Column(name = "OriginalHome")
    public String getOriginalHome() {
        return originalHome;
    }

    public void setOriginalHome(String originalHome) {
        this.originalHome = originalHome;
    }

    @Basic
    @Column(name = "GalleryID")
    public Integer getGalleryId() {
        return galleryId;
    }

    public void setGalleryId(Integer galleryId) {
        this.galleryId = galleryId;
    }

    @Basic
    @Column(name = "Cost")
    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    @Basic
    @Column(name = "MSRP")
    public BigDecimal getMsrp() {
        return msrp;
    }

    public void setMsrp(BigDecimal msrp) {
        this.msrp = msrp;
    }

    @Basic
    @Column(name = "ArtWorkLink")
    public String getArtWorkLink() {
        return artWorkLink;
    }

    public void setArtWorkLink(String artWorkLink) {
        this.artWorkLink = artWorkLink;
    }

    @Basic
    @Column(name = "GoogleLink")
    public String getGoogleLink() {
        return googleLink;
    }

    public void setGoogleLink(String googleLink) {
        this.googleLink = googleLink;
    }

    @Basic
    @Column(name = "sell")
    public Integer getSell() {return sell;}

    public void setSell(Integer sell) {this.sell = sell;}

    @Basic
    @Column(name = "heat")
    public Integer getHeat() {return heat;}

    public void setHeat(Integer heat) {this.heat = heat;}

    public String getSubjects() {
        return subjects;
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Artwork artwork = (Artwork) o;

        if (artWorkId != artwork.artWorkId) return false;
        if (artistId != null ? !artistId.equals(artwork.artistId) : artwork.artistId != null) return false;
        if (imageFileName != null ? !imageFileName.equals(artwork.imageFileName) : artwork.imageFileName != null)
            return false;
        if (title != null ? !title.equals(artwork.title) : artwork.title != null) return false;
        if (description != null ? !description.equals(artwork.description) : artwork.description != null) return false;
        if (excerpt != null ? !excerpt.equals(artwork.excerpt) : artwork.excerpt != null) return false;
        if (artWorkType != null ? !artWorkType.equals(artwork.artWorkType) : artwork.artWorkType != null) return false;
        if (yearOfWork != null ? !yearOfWork.equals(artwork.yearOfWork) : artwork.yearOfWork != null) return false;
        if (width != null ? !width.equals(artwork.width) : artwork.width != null) return false;
        if (height != null ? !height.equals(artwork.height) : artwork.height != null) return false;
        if (medium != null ? !medium.equals(artwork.medium) : artwork.medium != null) return false;
        if (originalHome != null ? !originalHome.equals(artwork.originalHome) : artwork.originalHome != null)
            return false;
        if (galleryId != null ? !galleryId.equals(artwork.galleryId) : artwork.galleryId != null) return false;
        if (cost != null ? !cost.equals(artwork.cost) : artwork.cost != null) return false;
        if (msrp != null ? !msrp.equals(artwork.msrp) : artwork.msrp != null) return false;
        if (artWorkLink != null ? !artWorkLink.equals(artwork.artWorkLink) : artwork.artWorkLink != null) return false;
        if (googleLink != null ? !googleLink.equals(artwork.googleLink) : artwork.googleLink != null) return false;
        if (sell != null ? !sell.equals(artwork.sell) : artwork.sell != null) return false;
        if (heat != null ? !heat.equals(artwork.heat) : artwork.heat != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = artWorkId;
        result = 31 * result + (artistId != null ? artistId.hashCode() : 0);
        result = 31 * result + (imageFileName != null ? imageFileName.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (excerpt != null ? excerpt.hashCode() : 0);
        result = 31 * result + (artWorkType != null ? artWorkType.hashCode() : 0);
        result = 31 * result + (yearOfWork != null ? yearOfWork.hashCode() : 0);
        result = 31 * result + (width != null ? width.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (medium != null ? medium.hashCode() : 0);
        result = 31 * result + (originalHome != null ? originalHome.hashCode() : 0);
        result = 31 * result + (galleryId != null ? galleryId.hashCode() : 0);
        result = 31 * result + (cost != null ? cost.hashCode() : 0);
        result = 31 * result + (msrp != null ? msrp.hashCode() : 0);
        result = 31 * result + (artWorkLink != null ? artWorkLink.hashCode() : 0);
        result = 31 * result + (googleLink != null ? googleLink.hashCode() : 0);
        result = 31 * result + (sell != null ? sell.hashCode() : 0);
        result = 31 * result + (heat != null ? heat.hashCode() : 0);
        return result;
    }
}
