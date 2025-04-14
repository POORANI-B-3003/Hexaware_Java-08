package com.hexaware.sis.db;

import java.sql.*;

public class EnrollmentReportService {

    public static void generateEnrollmentReport() {
        try (Connection conn = DatabaseConnection.getConnection()) {

            
            String getCourseId = "SELECT course_id FROM course WHERE course_name = 'Computer Science 101'";
            Statement stmt = conn.createStatement();
            ResultSet courseRs = stmt.executeQuery(getCourseId);

            if (courseRs.next()) {
                int courseId = courseRs.getInt("course_id");

                
                String getEnrollments = "SELECT s.student_id, s.name, s.email " +
                        "FROM enrollment e JOIN student s ON e.student_id = s.student_id " +
                        "WHERE e.course_id = " + courseId;

                ResultSet enrollmentsRs = stmt.executeQuery(getEnrollments);

                System.out.println(" Enrollment Report - Computer Science 101");
                 
                
                int count = 0;
                while (enrollmentsRs.next()) {
                    int studentId = enrollmentsRs.getInt("student_id");
                    String name = enrollmentsRs.getString("name");
                    String email = enrollmentsRs.getString("email");

                    System.out.println(" Student ID: " + studentId + ", Name: " + name + ", Email: " + email);
                    count++;
                }

                if (count == 0) {
                    System.out.println(" No students are enrolled in this course.");
                } else {
                    System.out.println("\n Total students enrolled: " + count);
                }

            } else {
                System.out.println(" Course 'Computer Science 101' not found.");
            }

        } catch (SQLException e) {
            System.out.println(" Error generating report: " + e.getMessage());
        }
    }
}
