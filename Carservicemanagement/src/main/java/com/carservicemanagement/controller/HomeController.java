package com.carservicemanagement.controller;

import com.carservicemanagement.service.HomeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = { "/home", "/dashboard", "/services", "/appointments", "/customers", "/reports" })
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final HomeService homeService = new HomeService();

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String path = request.getServletPath();
        String jspPage = homeService.resolvePage(path);

        if (jspPage != null) {
            request.getRequestDispatcher("/WEB-INF/pages/Home.jsp").forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

