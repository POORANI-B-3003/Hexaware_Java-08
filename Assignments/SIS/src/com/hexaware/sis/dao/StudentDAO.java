package com.hexaware.sis.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hexaware.sis.db.DatabaseConnection;

public class StudentDAO {

    // Method to insert a new student
    public static void insertStudent(String name, int age) {
        String sql = "INSERT INTO students (name, age) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, name);
            stmt.setInt(2, age);

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println(" New student inserted successfully!");
            }

        } catch (SQLException e) {
            System.out.println(" Error inserting student: " + e.getMessage());
        }
    }

    // Method to update an existing student
    public static void updateStudent(int studentId, String newName, int newAge) {
        String sql = "UPDATE students SET name = ?, age = ? WHERE student_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, newName);
            stmt.setInt(2, newAge);
            stmt.setInt(3, studentId);

            int rowsUpdated = stmt.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println(" Student updated successfully!");
            } else {
                System.out.println(" No student found with ID: " + studentId);
            }

        } catch (SQLException e) {
            System.out.println(" Error updating student: " + e.getMessage());
        }
    }
}
