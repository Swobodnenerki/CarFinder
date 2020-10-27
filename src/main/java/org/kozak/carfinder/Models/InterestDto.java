package org.kozak.carfinder.Models;

public class InterestDto {
    private int userId;
    private int advertId;
    private int accountId;

    public int getUserId() {
        return userId;
    }

    public int getAdvertId() {
        return advertId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setAdvertId(int advertId) {
        this.advertId = advertId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }
}
