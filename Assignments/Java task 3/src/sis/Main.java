package com.hexaware.sis.main;

import com.hexaware.sis.entity.Student;
import com.hexaware.sis.entity.Teacher;
import com.hexaware.sis.entity.Course;
import com.hexaware.sis.entity.Payment; // Assuming Payment is also in this package
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SIS sis = new SIS();

        // Create sample data
        Student s1 = new Student("1", "John", "Doe");
        Teacher t1 = new Teacher(1, "Dr. Smith", "smith@example.com", "Mathematics");
        Course c1 = new Course("MATH101", "Calculus");

        // Add to SIS system
        sis.addStudent(s1);
        sis.addTeacher(t1);
        sis.addCourse(c1);

        // Assign teacher and enroll student
        sis.assignTeacherToCourse(t1, c1);
        sis.enrollStudentInCourse(s1, c1);

        // Record a payment
        // Assuming you have a way to create a Payment object
        Payment p1 = new Payment(s1, 5000.0, new Date());
        sis.recordPayment(s1, 5000.0, new Date());

        // Generate reports
        sis.generateEnrollmentReport(c1);
        sis.generatePaymentReport(s1);
        sis.calculateCourseStatistics(c1);

        // Display details
        // Add these methods to Student, Course, and Teacher if you want to use them
        // s1.displayStudentInfo();
        // c1.displayCourseInfo();
        // t1.displayTeacherInfo();
    }
}
