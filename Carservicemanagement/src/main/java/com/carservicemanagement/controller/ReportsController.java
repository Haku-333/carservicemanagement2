package com.carservicemanagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReportsController {

    @RequestMapping("/reports")
    public String reports() {
        return "Reports";
    }
}
