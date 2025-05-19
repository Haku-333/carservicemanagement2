package com.carservicemanagement.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import com.carservicemanagement.service.LoginService;
import com.carservicemanagement.service.LoginResult;

import java.io.IOException;

@WebServlet(asyncSupported=true, urlPatterns= {"/","/login"})
public class logincontroller extends HttpServlet {  // ✅ Fixed class name casing

    private static final long serialVersionUID = 1L;
    private LoginService loginService;

    @Override
    public void init() throws ServletException {
        loginService = new LoginService();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Input validation
        if (username == null || username.trim().isEmpty() ||
            password == null || password.trim().isEmpty()) {
            request.setAttribute("message", "Username and password are required!");
            request.getRequestDispatcher("WEB-INF/Pages/Login.jsp").forward(request, response);
            return;
        }

        LoginResult result = loginService.authenticateUser(username, password);
        if (result.isSuccess()) {  // ✅ This is valid because result.isSuccess() returns a boolean
            // user is authenticated
        } else {
            // authentication failed
        }


        if (result.isSuccess()) {
            HttpSession session = request.getSession();
            session.setAttribute("username", result.getUsername());
            session.setAttribute("isLoggedIn", true);
            session.setMaxInactiveInterval(30 * 60); // 30 mins

            session.setAttribute("message", "Welcome back, " + result.getUsername() + "!");
            response.sendRedirect(request.getContextPath() + "/home");
        } else {
            request.setAttribute("message", result.getMessage());
            request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
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
            // Redirect to the context path + servlet path (e.g., /YourAppContext/login)
            response.sendRedirect(request.getContextPath() + request.getServletPath()); 
            return;
        }

        HttpSession session = request.getSession(false);
        if (session != null && Boolean.TRUE.equals(session.getAttribute("isLoggedIn"))) {
            // Redirect to the home controller path (e.g., /YourAppContext/home)
            response.sendRedirect(request.getContextPath() + "/home"); 
            return;
        }

        request.getRequestDispatcher("/WEB-INF/pages/Login.jsp").forward(request, response);
    }
   
}
