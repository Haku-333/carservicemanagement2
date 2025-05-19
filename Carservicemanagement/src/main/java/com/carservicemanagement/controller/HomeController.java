package com.carservicemanagement.controller;

import java.io.IOException;

import com.carservicemanagement.service.HomeService;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(asyncSupported = true, urlPatterns = { 
    "/home", 
    "/services", 
    // "/appointment", // Removed to be handled by Spring MVC AppointmentController
    "/customer", 
    "/reports" 
})
public class HomeController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private final HomeService homeService = new HomeService(); // This instance seems unused by the primary doGet logic now

    // doGet1 and doPost seem to be alternative/older logic not directly hit by the new routing
    protected void doGet1(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();
        String jspPage = homeService.resolvePage(path); // This logic is bypassed by the doGet override

        if (jspPage != null) {
            request.getRequestDispatcher(jspPage).forward(request, response);
        } else {
            response.sendError(HttpServletResponse.SC_NOT_FOUND, "Page not found");
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // If any of these pages need to handle POST, specific logic might be needed here
        // or in their own dedicated servlets. For now, redirecting to doGet.
        doGet(request, response); // Or perhaps doGet1 if that's the intended POST handler
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String path = request.getServletPath();
        String pageToForward = null;

        switch (path) {
            case "/home":
                pageToForward = "/WEB-INF/pages/Home.jsp";
                break;
            case "/services":
                pageToForward = "/WEB-INF/pages/Services.jsp";
                break;
            // case "/appointment": // Removed, handled by Spring MVC AppointmentController
            //    pageToForward = "/WEB-INF/pages/Appointment.jsp";
            //    break;
            case "/customer":
                pageToForward = "/WEB-INF/pages/Customer.jsp";
                break;
            case "/reports":
                pageToForward = "/WEB-INF/pages/Reports.jsp";
                break;
            default:
                // Default to home page or a 404 page if preferred
                pageToForward = "/WEB-INF/pages/Home.jsp"; 
                // Or handle as an error: 
                // response.sendError(HttpServletResponse.SC_NOT_FOUND, "Requested page not handled by this controller");
                // return;
                break;
        }

        if (pageToForward != null) {
            request.getRequestDispatcher(pageToForward).forward(request, response);
        } else {
             // This case should ideally not be reached if default is set in switch
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Could not determine page to display.");
        }
    }
}
