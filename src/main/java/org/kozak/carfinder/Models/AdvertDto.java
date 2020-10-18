package org.kozak.carfinder.Models;

public class AdvertDto {
    int advertId;
    String brand;
    String model;
    String type;
    String fuelType;
    String engine;
    String gearbox;
    String trim;
    String colour;
    double price;
    int dealerId;
    int photoId;
    String url;

    public int getAdvertId() {
        return advertId;
    }

    public String getBrand() {
        return brand;
    }
    public String getModel() {
        return model;
    }

    public String getType() {
        return type;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getEngine() {
        return engine;
    }

    public String getGearbox() {
        return gearbox;
    }

    public String getTrim() {
        return trim;
    }

    public String getColour() {
        return colour;
    }

    public double getPrice() {
        return price;
    }


    public int getDealerId() {
        return dealerId;
    }

    public int getPhotoId() {
        return photoId;
    }

    public String getUrl() {
        return url;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setGearbox(String gearbox) {
        this.gearbox = gearbox;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public void setPhotoId(int photoId) {
        this.photoId = photoId;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
