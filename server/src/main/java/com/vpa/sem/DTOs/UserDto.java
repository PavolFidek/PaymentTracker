package com.vpa.sem.DTOs;

public class UserDto {

    private Long id;

    private String firstName;

    private String lastName;

    private double payoutAmount;

    public UserDto(Long id, String firstName, String lastName, double payoutAmount) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payoutAmount = payoutAmount;
    }

    public UserDto() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
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
