package com.carservicemanagement.service;

public class HomeService {

    public String resolvePage(String path) {
        switch (path) {
            case "/home":
            case "/dashboard":
                return "/pages/Home.jsp";
            case "/services":
                return "/pages/Services.jsp";
            case "/appointments":
                return "/pages/Appointments.jsp";
            case "/customers":
                return "/pages/Customers.jsp";
            case "/reports":
                return "/pages/Reports.jsp";
            default:
                return null;
        }
    }
}
