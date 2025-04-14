package com.hexaware.sis.entity;

import java.util.*;
import java.util.List;

public class Teacher {
    private int teacherId;
    private String name;
    private String email;
    private String department;

    private List<Course> assignedCourses = new ArrayList<>();

    public Teacher(int teacherId, String name, String email, String department) {
        this.teacherId = teacherId;
        this.name = name;
        this.email = email;
        this.department = department;
    }

    public void assignCourse(Course course) {
        if (!assignedCourses.contains(course)) {
            assignedCourses.add(course);
        }
    }

    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }

    public String getName() {
        return name;
    }

    public void displayTeacherInfo() {
        System.out.println("Teacher ID: " + teacherId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Department: " + department);

        System.out.println("Assigned Courses:");
        if (assignedCourses.isEmpty()) {
            System.out.println("- None");
        } else {
            for (Course c : assignedCourses) {
                System.out.println("- " + c.getCourseName());
            }
        }
    }
}
