package org.kozak.carfinder.Models;

public class DealerDto {
    int dealerId;
    String name;
    String city;
    String street;
    int streetNumber;
    int userId;

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getDealerId() {
        return dealerId;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getStreetNumber() {
        return streetNumber;
    }

    public int getUserId() {
        return userId;
    }
}
