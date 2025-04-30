package com.carservicemanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegistrationService {

    private final String jdbcURL = "jdbc:mysql://localhost:8081/carservicemanagement?useSSL=false&serverTimezone=UTC";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "";

    public boolean registerUser(String fullName, String email, String username, String password) {
        boolean result = false;

        String INSERT_QUERY = "INSERT INTO `user registration` (FullName, Email, Username, Password) VALUES (?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
                 PreparedStatement stmt = conn.prepareStatement(INSERT_QUERY)) {

                stmt.setString(1, fullName);
                stmt.setString(2, email);
                stmt.setString(3, username);
                stmt.setString(4, password);

                int rowsInserted = stmt.executeUpdate();
                if (rowsInserted > 0) {
                    result = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }
    
}

