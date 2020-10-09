package org.kozak.carfinder.Models;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "advert", schema = "public", catalog = "Carfinder")
public class AdvertEntity {
    private Integer id;
    private String brand;
    private String model;
    private String type;
    private String fuelType;
    private String engine;
    private String gearbox;
    private String trim;
    private String colour;
    private double price;
    private DealerEntity dealerByDealerid;

    @Id
    @SequenceGenerator(name="advert_id_seq", sequenceName="advert_id_seq", allocationSize=1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="advert_id_seq")
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "brand", nullable = false, length = 30)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "model", nullable = false, length = 30)
    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Basic
    @Column(name = "type", nullable = false, length = 30)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "fuel_type", nullable = false, length = 30)
    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    @Basic
    @Column(name = "engine", nullable = false, length = 30)
    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    @Basic
    @Column(name = "gearbox", nullable = false, length = 30)
    public String getGearbox() {
        return gearbox;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    @Basic
    @Column(name = "trim", nullable = false, length = 30)
    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    @Basic
    @Column(name = "colour", nullable = false, length = 50)
    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    @Basic
    @Column(name = "price", nullable = false, length = 10)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AdvertEntity that = (AdvertEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (brand != null ? !brand.equals(that.brand) : that.brand != null) return false;
        if (model != null ? !model.equals(that.model) : that.model != null) return false;
        if (type != null ? !type.equals(that.type) : that.type != null) return false;
        if (fuelType != null ? !fuelType.equals(that.fuelType) : that.fuelType != null) return false;
        if (engine != null ? !engine.equals(that.engine) : that.engine != null) return false;
        if (gearbox != null ? !gearbox.equals(that.gearbox) : that.gearbox != null) return false;
        if (trim != null ? !trim.equals(that.trim) : that.trim != null) return false;
        if (colour != null ? !colour.equals(that.colour) : that.colour != null) return false;
        if(price != that.price) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (fuelType != null ? fuelType.hashCode() : 0);
        result = 31 * result + (engine != null ? engine.hashCode() : 0);
        result = 31 * result + (gearbox != null ? gearbox.hashCode() : 0);
        result = 31 * result + (trim != null ? trim.hashCode() : 0);
        result = 31 * result + (colour != null ? colour.hashCode() : 0);
        result = result + (int)price;
        return result;
    }
    @OneToOne
    @JoinColumn(name = "dealer_id", referencedColumnName = "id", nullable = false)
    @NotFound(action= NotFoundAction.IGNORE)
    public DealerEntity getDealerByDealerid() {
        return dealerByDealerid;
    }

    public void setDealerByDealerid(DealerEntity dealerByDealerid) {
        this.dealerByDealerid = dealerByDealerid;
    }
}
