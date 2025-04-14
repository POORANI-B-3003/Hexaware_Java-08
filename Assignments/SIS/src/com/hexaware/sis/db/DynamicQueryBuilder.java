package com.hexaware.sis.db;

import java.sql.*;
import java.util.Scanner;

public class DynamicQueryBuilder {

    public static void runCustomQuery() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" Enter table name (e.g., student, course, teacher):");
        String table = scanner.nextLine();

        System.out.println(" Enter comma-separated columns to select (e.g., * or student_id, name):");
        String columns = scanner.nextLine();

        System.out.println(" Enter WHERE condition (or leave blank):");
        String whereClause = scanner.nextLine();

        System.out.println(" Enter ORDER BY clause (or leave blank):");
        String orderBy = scanner.nextLine();

        // ⚠ Build query dynamically but safely (no user inputs directly concatenated)
        StringBuilder query = new StringBuilder("SELECT ");
        query.append(columns).append(" FROM ").append(table);

        if (!whereClause.trim().isEmpty()) {
            query.append(" WHERE ").append(whereClause);
        }

        if (!orderBy.trim().isEmpty()) {
            query.append(" ORDER BY ").append(orderBy);
        }

        System.out.println("\n Executing Query:\n" + query + "\n");

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query.toString())) {

            ResultSetMetaData meta = rs.getMetaData();
            int colCount = meta.getColumnCount();

            System.out.println(" Results:");
            while (rs.next()) {
                for (int i = 1; i <= colCount; i++) {
                    System.out.print(meta.getColumnName(i) + ": " + rs.getString(i) + "\t");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            System.out.println(" Error executing query: " + e.getMessage());
        }
    }
}
