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
        StringBuilder builder = new StringBuilder();
        builder.append(response.getStatus());
        builder.append("\n");
        response.getHeaderNames().forEach(name ->
                builder.append(name).append("/n")
        );
        return builder.toString();
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }
}
