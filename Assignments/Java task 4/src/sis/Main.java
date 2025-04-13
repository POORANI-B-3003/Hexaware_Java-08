package sis;

import com.hexaware.sis.entity.Student;
import com.hexaware.sis.entity.Teacher;
import com.hexaware.sis.entity.Course;
import com.hexaware.sis.exception.DuplicateEnrollmentException;
import com.hexaware.sis.exception.InvalidPaymentException;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        SIS sis = new SIS();

        // Create sample student, teacher, and course
        Student s1 = new Student("1", "John", "Doe");
        Teacher t1 = new Teacher(1, "Dr. Smith", "smith@example.com", "Mathematics");
        Course c1 = new Course("MATH101", "Calculus");

        // Add them to the system
        sis.addStudent(s1);
        sis.addTeacher(t1);
        sis.addCourse(c1);

        // Assign teacher to course
        sis.assignTeacherToCourse(t1, c1);

        // Enroll student in course with exception handling
        try {
            sis.enrollStudentInCourse(s1, c1);  // ✅ Success
            sis.enrollStudentInCourse(s1, c1);  // ❌ Will throw DuplicateEnrollmentException
        } catch (DuplicateEnrollmentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Record payments with exception handling
        try {
            sis.recordPayment(s1, 5000.0, new Date());  // ✅ Valid
            sis.recordPayment(s1, -100.0, new Date());  // ❌ InvalidPaymentException
        } catch (InvalidPaymentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Generate reports
        sis.generateEnrollmentReport(c1);
        sis.generatePaymentReport(s1);
        sis.calculateCourseStatistics(c1);

        // Optionally display full info
        // s1.displayStudentInfo();
        // c1.displayCourseInfo();
        // t1.displayTeacherInfo();
    }
}
