package com.vpa.sem.DTOs;

public class RegisterDto {

    private String userFirstName;

    private String userLastName;

    private String userLogin;

    private String userPassword;

    private double payoutAmount;

    public RegisterDto(String userFirstName, String userLastName, String userLogin, String userPassword, double payoutAmount) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userLogin = userLogin;
        this.userPassword = userPassword;
        this.payoutAmount = payoutAmount;
    }

    public String getUserFirstName() {
        return this.userFirstName;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public String getUserLastName() {
        return this.userLastName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public String getUserLogin() {
        return this.userLogin;
    }

    public void setUserLogin(String userLogin) {
        this.userLogin = userLogin;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public double getPayoutAmount() {
        return this.payoutAmount;
    }

    public void setPayoutAmount(double payoutAmount) {
        this.payoutAmount = payoutAmount;
    }
}
