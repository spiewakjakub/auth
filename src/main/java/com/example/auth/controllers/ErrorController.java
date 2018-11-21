package com.example.auth.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {
    @ResponseBody
    @RequestMapping("/error")
    public String handleError(HttpServletRequest request, HttpServletResponse response) {
        return Integer.valueOf(403).equals(response.getStatus()) ? "<h1>NIE MASZ AUTORYZACJI FIUCIE!!!111!!1!<h1/>" : Integer.toString(response.getStatus());
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
