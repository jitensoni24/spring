package com.dtech.sauth.api.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecuredResourceController {

    @RequestMapping("/secured")
    public void secureResource(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("accessing secured resource");
    }

    @RequestMapping("/login.html")
    public String login(HttpServletRequest request, HttpServletResponse response) {
       return "login";
    }

    @RequestMapping("/homepage.html")
    public String homepage(HttpServletRequest request, HttpServletResponse response) {
       return "homepage";
    }
    
    @RequestMapping("/adminpage")
    public String adminpage(HttpServletRequest request, HttpServletResponse response) {
       return "admin/adminpage";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(HttpServletRequest request, HttpServletResponse response) {
       return "accessDenied";
    }
}