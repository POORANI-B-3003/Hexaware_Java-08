package com.hexaware.sis.main;

import com.hexaware.sis.entity.Student;
import com.hexaware.sis.entity.Teacher;
import com.hexaware.sis.entity.Course;
import com.hexaware.sis.exception.DuplicateEnrollmentException;
import com.hexaware.sis.exception.InvalidPaymentException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SIS sis = new SIS();

        // Create student, teacher, and course
        Student s1 = new Student("1", "John", "Doe");
        Teacher t1 = new Teacher(1, "Dr. Smith", "smith@example.com", "Mathematics");
        Course c1 = new Course("MATH101", "Calculus");

        // Add them to the system
        sis.addStudent(s1);
        sis.addTeacher(t1);
        sis.addCourse(c1);

        // Add Enrollment with date
        sis.addEnrollment(s1, c1, new Date());

        // Assign Course to Teacher
        sis.assignCourseToTeacher(c1, t1);

        // Add Payment
        sis.addPayment(s1, 5000.0, new Date());

        // Retrieve Enrollments and Courses
        sis.getEnrollmentsForStudent(s1);
        sis.getCoursesForTeacher(t1);

        // Generate reports
        sis.generateEnrollmentReport(c1);
        sis.generatePaymentReport(s1);
        sis.calculateCourseStatistics(c1);

    }
}
