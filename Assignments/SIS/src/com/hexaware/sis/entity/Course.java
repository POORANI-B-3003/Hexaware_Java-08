package com.hexaware.sis.entity;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseId;
    private String courseName;

    private List<Student> enrolledStudents = new ArrayList<>();
    private Teacher assignedTeacher;

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Add a student to the course
    public void addStudent(Student student) {
        if (!enrolledStudents.contains(student)) {
            enrolledStudents.add(student);
        }
    }

    public List<Student> getEnrolledStudents() {
        return enrolledStudents;
    }

    public void assignTeacher(Teacher teacher) {
        this.assignedTeacher = teacher;
    }

    public Teacher getAssignedTeacher() {
        return assignedTeacher;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void displayEnrolledStudents() {
        System.out.println("Students enrolled in " + courseName + ":");
        if (enrolledStudents.isEmpty()) {
            System.out.println("No students enrolled.");
        } else {
            for (Student s : enrolledStudents) {
                System.out.println("- " + s.getFirstName() + " " + s.getLastName());
            }
        }
    }

    public void displayCourseInfo() {
        System.out.println("Course ID: " + courseId);
        System.out.println("Course Name: " + courseName);
        System.out.println("Teacher: " + (assignedTeacher != null ? assignedTeacher.getName() : "Not assigned"));
    }
}
