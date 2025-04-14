package com.hexaware.sis.db;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement()) {

            // Create Students table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS students (
                    student_id VARCHAR(10) PRIMARY KEY,
                    first_name VARCHAR(50),
                    last_name VARCHAR(50),
                    email VARCHAR(100),
                    phone VARCHAR(15)
                );
            """);

            // Create Teachers table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS teachers (
                    teacher_id INT PRIMARY KEY,
                    name VARCHAR(100),
                    email VARCHAR(100),
                    department VARCHAR(50)
                );
            """);

            // Create Courses table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS courses (
                    course_id VARCHAR(10) PRIMARY KEY,
                    course_name VARCHAR(100),
                    teacher_id INT,
                    FOREIGN KEY (teacher_id) REFERENCES teachers(teacher_id)
                );
            """);

            // Create Enrollments table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS enrollments (
                    enrollment_id INT AUTO_INCREMENT PRIMARY KEY,
                    student_id VARCHAR(10),
                    course_id VARCHAR(10),
                    enrollment_date DATE,
                    FOREIGN KEY (student_id) REFERENCES students(student_id),
                    FOREIGN KEY (course_id) REFERENCES courses(course_id)
                );
            """);

            // Create Payments table
            stmt.executeUpdate("""
                CREATE TABLE IF NOT EXISTS payments (
                    payment_id INT AUTO_INCREMENT PRIMARY KEY,
                    student_id VARCHAR(10),
                    amount DECIMAL(10,2),
                    payment_date DATE,
                    FOREIGN KEY (student_id) REFERENCES students(student_id)
                );
            """);

            System.out.println(" Tables created successfully!");

        } catch (Exception e) {
            System.out.println(" Error creating tables: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
