package com.example.auth.controllers;

import com.example.auth.entities.Role;
import com.example.auth.entities.User;
import com.example.auth.repositories.RoleRepository;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @GetMapping
    public List<User> publicContent() {

        return userRepository.findAll();
    }

    @GetMapping(value = "/private")
    public String privateContent() {
        Role role1 = roleRepository.getOne(1L);
        Role role2 = roleRepository.getOne(2L);
        Role role3 = roleRepository.getOne(3L);
        System.out.println(role1);
        System.out.println(role2);
        System.out.println(role3);
        User user1 = userRepository.save(new User("admin", "admin", new ArrayList<Role>() {{
            add(new Role("penis"));
        }}));
        User user2 = userRepository.save(new User("Bartek", "12345678", new ArrayList<Role>() {{
            add(new Role("kutas"));
            add(new Role("chuj"));
        }}));
        User user3 = userRepository.save(new User("Ola", "niepamietam4578", new ArrayList<Role>() {{
            add(new Role("pindol"));
            add(new Role("fiut"));
            add(new Role("fujara"));
        }}));



        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        return "<h1>PRIVATE MOTHERFUCKER</h1>";
    }
}
