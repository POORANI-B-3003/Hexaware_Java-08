package com.hexaware.sis.entity;

public class Course {
    private int courseId;
    private String courseName;
    private int credits;
    private int teacherId;

    // Constructor
    public Course(int courseId, String courseName, int credits, int teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.credits = credits;
        this.teacherId = teacherId;
    }

    // Getters
    public int getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCredits() {
        return credits;
    }

    public int getTeacherId() {
        return teacherId;
    }

    // Setters
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    // toString
    @Override
    public String toString() {
        return "Course{" +
                "ID=" + courseId +
                ", Name='" + courseName + '\'' +
                ", Credits=" + credits +
                ", TeacherID=" + teacherId +
                '}';
    }
}
