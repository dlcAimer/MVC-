package entity;

import javax.persistence.*;

/**
 * Created by 29252 on 2017/7/20.
 */
@Entity
@Table(name = "typesmatt", schema = "art")
public class Typesmatt {
    private int mattId;
    private String title;
    private String colorCode;

    @Id
    @Column(name = "MattID")
    public int getMattId() {
        return mattId;
    }

    public void setMattId(int mattId) {
        this.mattId = mattId;
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
    @Column(name = "ColorCode")
    public String getColorCode() {
        return colorCode;
    }

    public void setColorCode(String colorCode) {
        this.colorCode = colorCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Typesmatt that = (Typesmatt) o;

        if (mattId != that.mattId) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (colorCode != null ? !colorCode.equals(that.colorCode) : that.colorCode != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = mattId;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (colorCode != null ? colorCode.hashCode() : 0);
        return result;
    }
}
