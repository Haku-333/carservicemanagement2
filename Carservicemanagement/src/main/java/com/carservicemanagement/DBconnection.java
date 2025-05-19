package com.carservicemanagement;

import java.sql.*;

public class DBconnection {
    public static Connection getConnection() throws SQLException {
//        String dbUrl = System.getenv("DB_URL");
//        String dbUser = System.getenv("DB_USER");
//        String dbPassword = System.getenv("DB_PASSWORD");

//        if (dbUrl == null || dbUser == null) {
//            throw new SQLException("DB_URL and DB_USER environment variables must be set.");
//        }

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "");
    }
}
