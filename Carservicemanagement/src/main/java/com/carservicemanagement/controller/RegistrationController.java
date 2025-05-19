package com.carservicemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.carservicemanagement.service.RegistrationService;

import java.io.IOException;

@WebServlet(asyncSupported=true, urlPatterns={"/register"})
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
            request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");

        if ("logout".equals(action)) {
            HttpSession session = request.getSession(false);
            if (session != null) {
                session.invalidate();
            }
            response.sendRedirect("/WEB-INF/pages/Register.jsp");
            return;
        }

        HttpSession session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("isLoggedIn"))) {
            response.sendRedirect("/WEB-INF/pages/Home.jsp");
            return;
        }

        request.getRequestDispatcher("/WEB-INF/pages/Register.jsp").forward(request, response);
    }
}

