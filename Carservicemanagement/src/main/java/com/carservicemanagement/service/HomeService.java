package com.carservicemanagement.service;

public class HomeService {

    public String resolvePage(String path) {
        switch (path) {
            case "/home":
            case "/dashboard":
                return "/WEB-INF/pages/Home.jsp";
            case "/services":
                return "/WEB-INF/pages/Services.jsp";
            case "/appointments":
                return "/WEB-INF/pages/Appointments.jsp";
            case "/customers":
                return "/WEB-INF/pages/Customers.jsp";
            case "/reports":
                return "/WEB-INF/pages/Reports.jsp";
            default:
                return null;
        }
    }
}
