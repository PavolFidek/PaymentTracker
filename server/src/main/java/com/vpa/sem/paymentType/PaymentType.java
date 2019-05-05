package com.vpa.sem.paymentType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vpa.sem.payment.Payment;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "payment_type")
public class PaymentType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "type")
    @JsonIgnore
    private List<Payment> payments;

    public PaymentType() { }

    public PaymentType(String name) {
        this.name = name;
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}
