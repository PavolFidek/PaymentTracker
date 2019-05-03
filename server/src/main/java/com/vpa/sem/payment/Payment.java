package com.vpa.sem.payment;

import com.vpa.sem.paymentType.PaymentType;
import com.vpa.sem.user.User;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; // PK

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "ID")
    private User user; // FK to users table

    @Column()
    private String note;

    @Column(nullable = false)
    private Date realizationDate;

    @Column(nullable = false)
    private Double amount;

    @ManyToOne
    @JoinColumn(name = "PAYMENT_TYPE_ID", referencedColumnName = "ID")
    private PaymentType type; // FK to payment_type table

    public Payment(User user, String note, Date realizationDate, Double amount, PaymentType type) {
        this.user = user;
        this.note = note;
        this.realizationDate = realizationDate;
        this.amount = amount;
        this.type = type;
    }

    public Payment() {
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getRealizationDate() {
        return realizationDate;
    }

    public void setRealizationDate(Date realizationDate) {
        this.realizationDate = realizationDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }
}
