package com.carservicemanagement.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {
	    private final String jdbcURL = "jdbc:mysql://localhost:8081/carservicemanagement?useSSL=false&serverTimezone=UTC";
	    private final String jdbcUsername = "root";
	    private final String jdbcPassword = "";

	    public boolean validateUser(String username, String password) {
	        boolean result = false;
	        String SELECT_QUERY = "SELECT * FROM `user registration` WHERE Username=? AND Password=?";

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
	                 PreparedStatement stmt = conn.prepareStatement(SELECT_QUERY)) {

	                stmt.setString(1, username);
	                stmt.setString(2, password);

	                ResultSet rs = stmt.executeQuery();
	                result = rs.next(); // true if user exists
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return result;
	    }
	}


