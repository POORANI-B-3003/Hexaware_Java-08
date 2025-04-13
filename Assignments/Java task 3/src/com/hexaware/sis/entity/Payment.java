package com.hexaware.sis.entity;

import java.util.Date;

public class Payment {
    private Student student;
    private double amount;
    private Date paymentDate;

    public Payment(Student student, double amount, Date paymentDate) {
        this.student = student;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    public Student getStudent() {
        return student;
    }

    public double getPaymentAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }
}
