package com.hexaware.sis.db;

import java.sql.*;

public class PaymentService {

    public static void recordJanePayment() {
        try (Connection conn = DatabaseConnection.getConnection()) {

            // 1. Retrieve Student Record
            String checkStudent = "SELECT * FROM student WHERE student_id = 101";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(checkStudent);

            if (rs.next()) {
                double currentBalance = rs.getDouble("balance");
                System.out.println(" Current balance: $" + currentBalance);

                // 2. Insert Payment Record
                String insertPayment = "INSERT INTO payment (payment_id, student_id, amount, payment_date) VALUES (501, 101, 500.00, '2023-04-10')";
                stmt.executeUpdate(insertPayment);
                System.out.println(" Payment recorded for Jane Johnson.");

                // 3. Update Balance
                double updatedBalance = currentBalance - 500.00;
                String updateBalance = "UPDATE student SET balance = " + updatedBalance + " WHERE student_id = 101";
                stmt.executeUpdate(updateBalance);
                System.out.println(" Balance updated. New balance: $" + updatedBalance);

            } else {
                System.out.println(" Student with ID 101 not found.");
            }

        } catch (SQLException e) {
            System.out.println(" Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
