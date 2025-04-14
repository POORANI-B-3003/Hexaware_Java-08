package com.hexaware.sis.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TestDataInserter {

    public static void insertTestData() {
        try (Connection conn = DatabaseConnection.getConnection()) {

            // Step 1: Create Tables
            DatabaseInitializer.initialize();
            System.out.println(" Tables created successfully!");

            // Step 2: Insert Student
            System.out.println(" Inserting Student...");
            String insertStudent = "INSERT INTO student (student_id, name, email) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertStudent)) {
                ps.setInt(1, 1);
                ps.setString(2, "Poorani");
                ps.setString(3, "poorani@example.com");
                ps.executeUpdate();
            }

            // Step 3: Insert Course
            System.out.println(" Inserting Course...");
            String insertCourse = "INSERT INTO course (course_id, course_name, description) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertCourse)) {
                ps.setInt(1, 101);
                ps.setString(2, "Cloud Computing");
                ps.setString(3, "Learn AWS, Azure, GCP");
                ps.executeUpdate();
            }

            // Step 4: Insert Teacher
            System.out.println(" Inserting Teacher...");
            String insertTeacher = "INSERT INTO teacher (teacher_id, name, department) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertTeacher)) {
                ps.setInt(1, 201);
                ps.setString(2, "Dr. Ram");
                ps.setString(3, "Computer Science");
                ps.executeUpdate();
            }

            // Step 5: Insert Enrollment
            System.out.println(" Inserting Enrollment...");
            String insertEnrollment = "INSERT INTO enrollment (enrollment_id, student_id, course_id) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertEnrollment)) {
                ps.setInt(1, 301);
                ps.setInt(2, 1);    
                ps.setInt(3, 101);  
                ps.executeUpdate();
            }

            // Step 6: Insert Payment
            System.out.println(" Inserting Payment...");
            String insertPayment = "INSERT INTO payment (payment_id, student_id, amount, payment_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(insertPayment)) {
                ps.setInt(1, 401);
                ps.setInt(2, 1);    
                ps.setDouble(3, 999.99);
                ps.setString(4, "2025-04-14");
                ps.executeUpdate();
            }

            System.out.println(" All test data inserted successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
