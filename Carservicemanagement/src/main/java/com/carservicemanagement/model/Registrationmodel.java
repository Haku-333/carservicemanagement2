package com.carservicemanagement.model;

import java.sql.*;

public class Registrationmodel {

    // Database connection settings
    private static final String DB_URL = "jdbc:mysql://localhost:3306/car_service_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    // Method to insert a new user
    public boolean registerUser(String fullname, String email, String username, String password) {
        boolean isRegistered = false;

        String sql = "INSERT INTO users (fullname, email, username, password) VALUES (?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, fullname);
            stmt.setString(2, email);
            stmt.setString(3, username);
            stmt.setString(4, password); // You should hash passwords in production

            int rowsAffected = stmt.executeUpdate();
            isRegistered = rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return isRegistered;
    }

    // Optional: check if username or email already exists
    public boolean isUserExists(String username, String email) {
        boolean exists = false;

        String sql = "SELECT * FROM users WHERE username = ? OR email = ?";

        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, email);

            try (ResultSet rs = stmt.executeQuery()) {
                exists = rs.next(); // true if any record found
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return exists;
    }
}
