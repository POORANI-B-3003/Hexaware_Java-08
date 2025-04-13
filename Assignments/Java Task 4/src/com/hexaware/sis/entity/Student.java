package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;
    private List<Payment> payments;
    private List<Course> enrolledCourses; // Added declaration

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.payments = new ArrayList<>();
        this.enrolledCourses = new ArrayList<>(); // Added initialization
    }

    public String getStudentId() {
        return studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
    

    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void enrollInCourse(Course course) {
        enrolledCourses.add(course);
    }

    public List<Course> getEnrolledCourses() {
        return enrolledCourses;
    }

    public void displayPayments() {
        System.out.println("Payments for " + firstName + " " + lastName + ":");
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
        } else {
            for (Payment p : payments) {
                if (p != null) { // Added null check
                    System.out.println("- Amount: " + p.getPaymentAmount() + ", Date: " + p.getPaymentDate());
                } else {
                    System.out.println("- (Null Payment)"); // Handle null payment case
                }
            }
        }
    }
}