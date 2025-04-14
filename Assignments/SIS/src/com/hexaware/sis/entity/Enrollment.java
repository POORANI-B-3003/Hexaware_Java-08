package com.hexaware.sis.entity;

import java.util.*;

public class Enrollment {
    private Student student;
    private Course course;
    private Date enrollmentDate;

    public Enrollment(Student student, Course course, Date enrollmentDate) {
        this.student = student;
        this.course = course;
        this.enrollmentDate = enrollmentDate;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }

    public Date getEnrollmentDate() {
        return enrollmentDate;
    }
}
