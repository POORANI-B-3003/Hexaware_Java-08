package com.hexaware.sis.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherAssignmentService {

    public static void assignTeacherToCourse() {
        try (Connection conn = DatabaseConnection.getConnection()) {
            // Step 1: Insert Teacher 
            String insertTeacher = "INSERT INTO teacher (teacher_id, teacher_name, email, expertise) "
            		+ "VALUES (1, 'Sarah Smith', 'sarah.smith@example.com', 'Computer Science')";
            PreparedStatement psTeacher = conn.prepareStatement(insertTeacher);
            psTeacher.executeUpdate();
            System.out.println(" Teacher Sarah Smith added.");

            // Step 2: Retrieve Course by Course Code
            String getCourse = "SELECT * FROM course WHERE course_code = 'CS302'";
            PreparedStatement psCourse = conn.prepareStatement(getCourse);
            ResultSet rs = psCourse.executeQuery();

            if (rs.next()) {
                // Step 3: Update Course Record with Sarah as Instructor
                String updateCourse = "UPDATE course SET teacher_id = ? WHERE course_code = ?";
                PreparedStatement psUpdate = conn.prepareStatement(updateCourse);
                psUpdate.setInt(1, 1); 
                psUpdate.setString(2, "CS302");
                psUpdate.executeUpdate();
                System.out.println(" Sarah Smith assigned to teach 'Advanced Database Management'.");
            } else {
                System.out.println(" Course with code CS302 not found.");
            }

        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
