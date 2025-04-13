package com.hexaware.sis.entity;

public class Teacher {
    private int teacherId;
    private String firstName;
    private String lastName;
    private String email;

    // Constructor
    public Teacher(int teacherId, String firstName, String lastName, String email) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    // Getters
    public int getTeacherId() {
        return teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    // Setters
    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString
    @Override
    public String toString() {
        return "Teacher{" +
                "ID=" + teacherId +
                ", Name='" + firstName + " " + lastName + '\'' +
                ", Email='" + email + '\'' +
                '}';
    }
}
