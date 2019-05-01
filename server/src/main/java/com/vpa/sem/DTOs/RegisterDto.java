package com.vpa.sem.DTOs;

public class RegisterDto {

    private String firstName;

    private String lastName;

    private String login;

    private String password;

    private double payoutAmount;

    public RegisterDto(String firstName, String lastName, String login, String password, double payoutAmount) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.payoutAmount = payoutAmount;
    }

    public String getUserFirstName() {
        return this.firstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.firstName = userFirstName;
    }

    public String getUserLastName() {
        return this.lastName;
    }

    public void setUserLastName(String userLastName) {
        this.lastName = userLastName;
    }

    public String getUserLogin() {
        return this.login;
    }

    public void setUserLogin(String userLogin) {
        this.login = userLogin;
    }

    public String getUserPassword() {
        return this.password;
    }

    public void setUserPassword(String userPassword) {
        this.password = userPassword;
    }

    public double getPayoutAmount() {
        return this.payoutAmount;
    }

    public void setPayoutAmount(double payoutAmount) {
        this.payoutAmount = payoutAmount;
    }
}
