package com.example.attendancetracker.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // Applied your new northeast region pooler host and configuration parameters
    private static final String URL = "jdbc:postgresql://aws-1-ap-northeast-1.pooler.supabase.com:5432/postgres";
    private static final String USER = "postgres.yvyakpttifhjxjvuqdek"; // Your complete project-scoped pooler user
    private static final String PASSWORD = "sEgBESuAH5LH98X2"; // Replace with your current database password if you changed it

    public static Connection getConnection() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("PostgreSQL JDBC Driver not found in classpath.", e);
        }
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}