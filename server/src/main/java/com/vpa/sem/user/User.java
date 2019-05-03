package com.vpa.sem.user;

import com.vpa.sem.payment.Payment;
import com.vpa.sem.role.Role;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, unique = true)
    private String login;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private double payoutAmount;

    @ManyToMany
    @JoinTable(
            name = "user_role",
            joinColumns = {@JoinColumn(name = "USER_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID", referencedColumnName = "ID")}
    )
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private List<Payment> payments;

    public User() {
    }

    public User(String firstName, String lastName, String login, String password, double payoutAmount, List<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.login = login;
        this.password = password;
        this.payoutAmount = payoutAmount;
        this.roles = roles;
    }

    public Long getId() {
        return this.id;
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

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getPayoutAmount() {
        return this.payoutAmount;
    }

    public void setPayoutAmount(double payoutAmount) {
        this.payoutAmount = payoutAmount;
    }

    public List<Role> getRoles() {
        return this.roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public List<Payment> getPayments() {
        return this.payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
