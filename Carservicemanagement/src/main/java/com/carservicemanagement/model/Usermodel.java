package com.carservicemanagement.model;

import java.sql.*;

public class Usermodel {

    // JDBC connection parameters
    private static final String DB_URL = "jdbc:mysql://localhost:3306/car_service_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Method to validate user credentials
    public boolean validateUser(String username, String password) {
        boolean isValid = false;

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password); // In production, use hashed passwords

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    isValid = true;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isValid;
    }
}
