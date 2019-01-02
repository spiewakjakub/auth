package com.example.auth.controllers;

import com.example.auth.entities.Token;
import com.example.auth.entities.User;
import com.example.auth.services.TokenService;
import com.example.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class MainController {
    private final UserService applicationUserService;
    private final TokenService tokenService;

    @Autowired
    public MainController(UserService applicationUserService, TokenService tokenService) {
        this.applicationUserService = applicationUserService;
        this.tokenService = tokenService;
    }

    @GetMapping("/users")
    public List<User> getAll() {
        return applicationUserService.getAll()
                .stream()
                .peek(user -> user.setPassword("********"))
                .collect(Collectors.toList());
    }

    @GetMapping("/tokens")
    public List<Token> getAllTokens() {
        return tokenService.getAll();
    }

    @GetMapping("private/users")
    public List<User> getAllPrivate() {
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
