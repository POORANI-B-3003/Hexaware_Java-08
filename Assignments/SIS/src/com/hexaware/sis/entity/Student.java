package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String studentId;
    private String firstName;
    private String lastName;

    private List<Course> courses = new ArrayList<>();
    private List<Payment> payments = new ArrayList<>();

    public Student(String studentId, String firstName, String lastName) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Enroll in a course
    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    // Add a payment
    public void addPayment(Payment payment) {
        payments.add(payment);
    }

    // Get all payments
    public List<Payment> getPayments() {
        return payments;
    }

    // Get all courses
    public List<Course> getCourses() {
        return courses;
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

    public void displayPayments() {
        System.out.println("Payments for " + firstName + " " + lastName + ":");
        if (payments.isEmpty()) {
            System.out.println("No payments found.");
        } else {
            for (Payment p : payments) {
                System.out.println("- Amount: ₹" + p.getPaymentAmount() + ", Date: " + p.getPaymentDate());
            }
        }
    }
}
