package org.kozak.carfinder.Models;

public class InterestDto {
    private int userId;
    private int advertId;

    public int getUserId() {
        return userId;
    }

    public int getAdvertId() {
        return advertId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }
}
