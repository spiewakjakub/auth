package com.example.auth.controllers;

import com.example.auth.entities.Role;
import com.example.auth.entities.User;
import com.example.auth.repositories.RoleRepository;
import com.example.auth.repositories.UserRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainController {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public MainController(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @GetMapping(value = "/roles")
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @GetMapping(value = "/public/users")
    public List<User> getAllUser() {
        return userRepository.findAll();
    }
}
