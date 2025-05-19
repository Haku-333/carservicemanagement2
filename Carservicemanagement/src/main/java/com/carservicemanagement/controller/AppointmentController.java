package com.carservicemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.carservicemanagement.model.Appointment;

@Controller
public class AppointmentController {

    @GetMapping("/appointment")
    public String showAppointmentForm(Appointment appointment) { 
        return "Appointment"; 
    }

    @PostMapping("/appointment")
    public String saveAppointment(@ModelAttribute("appointment") Appointment appointment, RedirectAttributes redirectAttributes) {
        System.out.println("Received appointment to save:");
        System.out.println("Vehicle: " + (appointment.getVehicle() != null ? appointment.getVehicle().toString() : "N/A")); 
        System.out.println("Date: " + appointment.getAppointmentDate());
        System.out.println("Time Slot: " + appointment.getTimeSlot());
        System.out.println("Status: " + appointment.getStatus());
        
        redirectAttributes.addFlashAttribute("message", "Appointment saved successfully!");
        
        return "redirect:/appointment"; 
    }
}
