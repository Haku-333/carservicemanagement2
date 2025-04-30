package com.carservicemanagement.model;

import java.sql.*;

public class Registrationmodel {
    private String jdbcURL = "jdbc:mysql://localhost:3306/test1";
    private String jdbcUsername = "root";
    private String jdbcPassword = ""; // Use your password if any

    private static final String INSERT_USER_SQL = 
        "INSERT INTO `user registration`(`Full Name`, `Email`, `Username`, `Password`) VALUES (?, ?, ?, ?)";
    private static final String SELECT_USER_SQL = 
        "SELECT * FROM `user registration` WHERE `Username` = ? AND `Password` = ?";

    protected Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public boolean registerUser(String fullName, String email, String username, String password) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_USER_SQL)) {
            stmt.setString(1, fullName);
            stmt.setString(2, email);
            stmt.setString(3, username);
            stmt.setString(4, password);
            return stmt.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean validateUser(String username, String password) {
        try (Connection conn = getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_USER_SQL)) {
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
            return rs.next(); // Valid if a match is found
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
