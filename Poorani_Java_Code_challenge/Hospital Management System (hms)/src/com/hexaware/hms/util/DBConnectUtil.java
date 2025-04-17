package com.hexaware.hms.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/hms";
    private static final String USER = "root";
    private static final String PASSWORD = "Poors@30";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
