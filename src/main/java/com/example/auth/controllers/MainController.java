package com.example.auth.controllers;

import com.example.auth.entities.User;
import com.example.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MainController {
    private final UserService applicationUserService;

    @Autowired
    public MainController(UserService applicationUserService) {
        this.applicationUserService = applicationUserService;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return applicationUserService.getAll()
                .stream()
                .peek(user -> user.setPassword("********"))
                .collect(Collectors.toList());
    }

    @GetMapping("private/users")
    public List<User> getAllPrivate(Authentication principal) {
        System.out.println(principal.getDetails());
        return applicationUserService.getAll();
    }

    @GetMapping("/users/id/{id}")
    public Optional<User> getById(@PathVariable Long id) {
        return applicationUserService.getById(id);
    }

    @GetMapping("/users/{username}")
    public Optional<User> getByUsername(@PathVariable String username) {
        return applicationUserService.getByUsername(username);
    }

    @PutMapping("/users")
    public Optional<User> insert(@RequestBody User user) {
        return applicationUserService.save(user);
    }
}
