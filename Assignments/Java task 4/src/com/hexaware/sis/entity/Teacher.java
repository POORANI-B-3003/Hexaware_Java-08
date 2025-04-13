package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    private int teacherId;
    private String name;
    private String email;
    private String expertise;
    private List<Course> assignedCourses;

    public Teacher(int teacherId, String name, String email, String expertise) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.expertise = expertise;
        this.assignedCourses = new ArrayList<>();
    }

    public void updateTeacherInfo(String name, String email, String expertise) {
        this.name = name;
        this.email = email;
        this.expertise = expertise;
    }

    public void displayTeacherInfo() {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Expertise: " + expertise);
    }

    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public void assignCourse(Course course) {
        assignedCourses.add(course);
    }

    public String getName() {
        return name;
    }
    public Teacher(){
        assignedCourses = new ArrayList<>();
    }

    
}
