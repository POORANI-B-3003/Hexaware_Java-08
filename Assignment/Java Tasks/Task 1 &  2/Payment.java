package com.hexaware.sis.entity;

import java.util.Date;

public class Payment {
    private int paymentId;
    private int studentId;
    private double amount;
    private Date paymentDate;

    // Constructor
    public Payment(int paymentId, int studentId, double amount, Date paymentDate) {
        this.paymentId = paymentId;
        this.studentId = studentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
    }

    // Getters
    public int getPaymentId() {
        return paymentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    // Setters
    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    // toString
    @Override
    public String toString() {
        return "Payment{" +
                "ID=" + paymentId +
                ", StudentID=" + studentId +
                ", Amount=" + amount +
                ", Date=" + paymentDate +
                '}';
    }
}
