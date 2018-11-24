package com.example.auth.controllers;

import com.example.auth.entities.ApplicationUser;
import com.example.auth.services.ApplicationUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MainController {
    private final ApplicationUserService applicationUserService;

    @Autowired
    public MainController(ApplicationUserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/users")
    public List<ApplicationUser> getAll() {
        return applicationUserService.getAll();
    }

    @GetMapping("/users/id/{id}")
    public Optional<ApplicationUser> getById(@PathVariable Long id) {
        return applicationUserService.getById(id);
    }

    @GetMapping("/users/{username}")
    public Optional<ApplicationUser> getByUsername(@PathVariable String username) {
        return applicationUserService.getByUsername(username);
    }

    @PutMapping("/users")
    public Optional<ApplicationUser> insert(@RequestBody ApplicationUser applicationUser) {
        return applicationUserService.save(applicationUser);
    }


}
