package com.hexaware.hms.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DBPropertyUtil {

    // This method reads the DB details from a file and returns the connection string
    public static String getConnectionString(String fileName) {
        Properties props = new Properties();
        String connectionString = "";

        try {
            // Load the properties file
            FileInputStream file = new FileInputStream(fileName);
            props.load(file);

            // Read values from the file
            String host = props.getProperty("host");
            String port = props.getProperty("port");
            String dbname = props.getProperty("dbname");

            // Create the connection string
            connectionString = "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?useSSL=false";

        } catch (IOException e) {
            System.out.println("Error reading db.properties file: " + e.getMessage());
        }

        return connectionString;
    }
}
