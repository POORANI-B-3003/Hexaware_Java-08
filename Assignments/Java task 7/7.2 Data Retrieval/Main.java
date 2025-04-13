package sis;

import com.hexaware.sis.db.DataRetrieval;
import com.hexaware.sis.entity.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = DataRetrieval.getAllStudents();
        System.out.println("📋 Students:");
        for (Student s : students) {
            System.out.println(s.getStudentId() + ": " + s.getFirstName() + " " + s.getLastName());
        }

        List<Course> courses = DataRetrieval.getAllCourses();
        System.out.println("\n📘 Courses:");
        for (Course c : courses) {
            System.out.println(c.getCourseId() + ": " + c.getCourseName());
        }

        List<String> enrollments = DataRetrieval.getEnrollmentsByStudentId("1");
        System.out.println("\n📌 Enrollments for Student ID 1:");
        for (String e : enrollments) {
            System.out.println(" - Enrolled in: " + e);
        }

        List<String> payments = DataRetrieval.getPaymentsByStudentId("1");
        System.out.println("\n💰 Payments for Student ID 1:");
        for (String p : payments) {
            System.out.println(" - " + p);
        }
    }
}
