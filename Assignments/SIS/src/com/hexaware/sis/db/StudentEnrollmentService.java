package com.hexaware.sis.db;

import java.sql.Connection;
import java.sql.Statement;

public class StudentEnrollmentService {

    public static void enrollJohnDoe() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            // 1. Insert Student
            String insertStudent = "INSERT INTO student (student_id, name, email, dob, phone) " +
                    "VALUES (2, 'John Doe', 'john.doe@example.com', '1995-08-15', '123-456-7890')";
            stmt.executeUpdate(insertStudent);
            System.out.println(" John Doe added to student table.");

            // 2. Insert Courses
            String course1 = "INSERT INTO course (course_id, course_name, description) " +
                    "VALUES (201, 'Introduction to Programming', 'Basics of programming')";
            String course2 = "INSERT INTO course (course_id, course_name, description) " +
                    "VALUES (202, 'Mathematics 101', 'Fundamentals of Math')";
            stmt.executeUpdate(course1);
            stmt.executeUpdate(course2);
            System.out.println(" Courses added.");

            // 3. Enroll John
            String enroll1 = "INSERT INTO enrollment (enrollment_id, student_id, course_id) " +
                    "VALUES (301, 2, 201)";
            String enroll2 = "INSERT INTO enrollment (enrollment_id, student_id, course_id) " +
                    "VALUES (302, 2, 202)";
            stmt.executeUpdate(enroll1);
            stmt.executeUpdate(enroll2);
            System.out.println(" John Doe enrolled in both courses.");

        } catch (Exception e) {
            System.out.println(" Error: " + e.getMessage());
        }
    }
}
