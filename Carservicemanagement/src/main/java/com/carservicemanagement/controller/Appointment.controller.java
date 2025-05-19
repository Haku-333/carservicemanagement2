package com.carservicemanagement.controller;

import com.carservicemanagement.model.Appointment;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "AppointmentController", urlPatterns = {"/appointment"})
public class AppointmentController extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Just forward to the JSP form page
        request.getRequestDispatcher("/WEB-INF/pages/Appointment.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Read form fields
        String vehicle = request.getParameter("vehicle");
        String appointmentDate = request.getParameter("appointmentDate");
        String timeSlot = request.getParameter("timeSlot");
        String status = request.getParameter("status");

        // You could also create an Appointment object
        Appointment appointment = new Appointment();
        appointment.setVehicle(vehicle);
        appointment.setAppointmentDate(appointmentDate);
        appointment.setTimeSlot(timeSlot);
        appointment.setStatus(status);

        // Debug printout (same as Spring version)
        System.out.println("Received appointment to save:");
        System.out.println("Vehicle: " + vehicle);
        System.out.println("Date: " + appointmentDate);
        System.out.println("Time Slot: " + timeSlot);
        System.out.println("Status: " + status);

        // Set a success message
        HttpSession session = request.getSession();
        session.setAttribute("message", "Appointment saved successfully!");

        // Redirect to GET /appointment
        response.sendRedirect(request.getContextPath() + "/appointment");
    }
}
