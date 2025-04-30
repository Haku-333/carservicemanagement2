package com.carservicemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.carservicemanagement.service.RegistrationService;

import java.io.IOException;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private RegistrationService registrationService;

    @Override
    public void init() throws ServletException {
        registrationService = new RegistrationService(); // initialize service
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fullName = request.getParameter("fullname");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        boolean isRegistered = registrationService.registerUser(fullName, email, username, password);

        if (isRegistered) {
            request.setAttribute("message", "User registered successfully!");
            request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
        } else {
            request.setAttribute("message", "Registration failed!");
            request.getRequestDispatcher("/WEB-INF/pages/Registration.jsp").forward(request, response);
        }
    }
}

