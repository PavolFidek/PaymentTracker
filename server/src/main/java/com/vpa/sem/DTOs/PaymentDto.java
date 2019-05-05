package com.vpa.sem.DTOs;

import com.vpa.sem.paymentType.PaymentType;

import java.util.Date;

public class PaymentDto {

    private Long id;

    private String note;

    private Date realizationDate;

    private Double amount;

    private PaymentType type;

    public PaymentDto(Long id, String note, Date realizationDate, Double amount, PaymentType type) {
        this.id = id;
        this.note = note;
        this.realizationDate = realizationDate;
        this.amount = amount;
        this.type = type;
    }

    public PaymentDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
