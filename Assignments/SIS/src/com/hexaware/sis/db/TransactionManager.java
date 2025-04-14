package com.hexaware.sis.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionManager {

    public static void enrollStudentAndMakePayment(
            int studentId, int courseId, int enrollmentId,
            int paymentId, double amount, String paymentDate) {

        Connection conn = null;

        try {
            conn = DatabaseConnection.getConnection();
            conn.setAutoCommit(false);  // 🔐 Begin transaction

            // Insert Enrollment
            String enrollSQL = "INSERT INTO enrollment (enrollment_id, student_id, course_id) VALUES (?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(enrollSQL)) {
                ps.setInt(1, enrollmentId);
                ps.setInt(2, studentId);
                ps.setInt(3, courseId);
                ps.executeUpdate();
                System.out.println("✅ Enrollment successful");
            }

            // Insert Payment
            String paymentSQL = "INSERT INTO payment (payment_id, student_id, amount, payment_date) VALUES (?, ?, ?, ?)";
            try (PreparedStatement ps = conn.prepareStatement(paymentSQL)) {
                ps.setInt(1, paymentId);
                ps.setInt(2, studentId);
                ps.setDouble(3, amount);
                ps.setString(4, paymentDate);
                ps.executeUpdate();
                System.out.println("✅ Payment successful");
            }

            conn.commit();  // ✅ Commit both
            System.out.println("🎉 Transaction committed successfully!");

        } catch (SQLException e) {
            System.out.println("❌ Transaction failed. Rolling back...");
            e.printStackTrace();

            try {
                if (conn != null) conn.rollback();  // ❌ Undo everything
            } catch (SQLException rollbackEx) {
                System.out.println("❌ Rollback also failed!");
                rollbackEx.printStackTrace();
            }

        } finally {
            try {
                if (conn != null) conn.setAutoCommit(true);  // Always reset
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
