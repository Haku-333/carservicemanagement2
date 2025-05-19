package com.carservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class CarServiceController {

    @GetMapping("home")
    public String showHome() {
        return "Home";
    }

    @GetMapping("customer")
    public String showCustomer() {
        return "Customer";
    }

    @GetMapping("appointment")
    public String showAppointment() {
        return "Appointment";
    }

    @GetMapping("services")
    public String showServices() {
        return "Services";
    }

    @GetMapping("reports")
    public String showReports() {
        return "Reports";
    }

    @GetMapping("login")
    public String showLogin() {
        return "Login";
    }

    @GetMapping("register")
    public String showRegister() {
        return "Register";
    }
}
