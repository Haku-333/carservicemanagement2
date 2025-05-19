package com.carservicemanagement.service;

import java.sql.*;
import com.carservicemanagement.service.LoginResult;

public class LoginService {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/carservicemanagement";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    public LoginResult authenticateUser(String username, String password) {
        LoginResult result = new LoginResult();

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
        try {
        Class.forName("com.mysql.cj.jdbc.Driver"); // Load driver
        } catch (Exception e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    result.setSuccess(true);
                    result.setUsername(username);
                    result.setMessage("Login successful.");
                } else {
                    result.setSuccess(false);
                    result.setMessage("Invalid username or password.");
                }
            }

        } catch (SQLException e) {
            result.setSuccess(false);
            result.setMessage("Database error: " + e.getMessage());
            e.printStackTrace();
        }

        return result;
    }
}
