package com.vpa.sem.DTOs;

public class UserDto {

    private int userId;

    private String firstName;

    private String lastName;

    private double payoutAmount;

    public UserDto(int userId, String firstName, String lastName, double payoutAmount) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payoutAmount = payoutAmount;
    }

    public int getUserId() {
        return this.userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getPayoutAmount() {
        return this.payoutAmount;
    }

    public void setPayoutAmount(double payoutAmount) {
        this.payoutAmount = payoutAmount;
    }
}
