package com.carservicemanagement.service;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class login
 */
public class login extends HttpServlet {
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        UserModel userModel = new UserModel();
	        boolean isValid = userModel.validateUser(username, password);

	        if (isValid) {
	            HttpSession session = request.getSession();
	            session.setAttribute("username", username);
	            response.sendRedirect("pages/Home.jsp");
	        } else {
	            response.sendRedirect("Login.jsp?error=1");
	        }
	    }
	}
	