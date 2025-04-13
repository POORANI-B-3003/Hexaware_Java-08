package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;
    private List<Student> enrolledStudents;
    private Teacher assignedTeacher; // Added declaration

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.enrolledStudents = new ArrayList<>();
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void addStudent(Student student) {
        enrolledStudents.add(student);
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student student : enrolledStudents) {
                if (student != null) { // Added null check
                    System.out.println("- " + student.getFirstName() + " " + student.getLastName());
                } else {
                    System.out.println("- (Null Student)"); // Handle null student case
                }
            }
        }
    }

    public void assignTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
    }

    public Teacher getTeacher() {
        return assignedTeacher;
    }
}