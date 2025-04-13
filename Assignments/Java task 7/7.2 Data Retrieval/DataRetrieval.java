package com.hexaware.sis.db;

import java.sql.*;
import com.hexaware.sis.entity.*;
import java.util.*;

public class DataRetrieval {

    public static List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student")) {

            while (rs.next()) {
                Student student = new Student(
                    rs.getString("student_id"),
                    rs.getString("first_name"),
                    rs.getString("last_name")
                );
                students.add(student);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving students: " + e.getMessage());
        }
        return students;
    }

    public static List<Course> getAllCourses() {
        List<Course> courses = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM course")) {

            while (rs.next()) {
                Course course = new Course(
                    rs.getString("course_id"),
                    rs.getString("course_name")
                );
                courses.add(course);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving courses: " + e.getMessage());
        }
        return courses;
    }

    public static List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM teacher")) {

            while (rs.next()) {
                Teacher teacher = new Teacher(
                    rs.getInt("teacher_id"),
                    rs.getString("teacher_name"),
                    rs.getString("email"),
                    rs.getString("department")
                );
                teachers.add(teacher);
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving teachers: " + e.getMessage());
        }
        return teachers;
    }

    public static List<String> getEnrollmentsByStudentId(String studentId) {
        List<String> enrollments = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                 "SELECT course_id FROM enrollment WHERE student_id = ?")) {

            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                enrollments.add(rs.getString("course_id"));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving enrollments: " + e.getMessage());
        }
        return enrollments;
    }

    public static List<String> getPaymentsByStudentId(String studentId) {
        List<String> payments = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(
                 "SELECT amount, payment_date FROM payment WHERE student_id = ?")) {

            pstmt.setString(1, studentId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                double amount = rs.getDouble("amount");
                Date date = rs.getDate("payment_date");
                payments.add("₹" + amount + " on " + date.toString());
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving payments: " + e.getMessage());
        }
        return payments;
    }
}
