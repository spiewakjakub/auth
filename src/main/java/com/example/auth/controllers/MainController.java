package com.example.auth.controllers;

import com.example.auth.entities.User;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@RestController
public class MainController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public List<User> publicContent() {

        return repository.findAll();
    }

    @GetMapping(value = "/private")
    public String privateContent() {
        User user1 = repository.save(new User("admin", "admin", null));
        User user2 = repository.save(new User("Bartek", "12345678", null));
        User user3 = repository.save(new User("Ola", "niepamietam4578", null));
        repository.flush();


        System.out.println(user1);
        System.out.println(user2);
        System.out.println(user3);

        return "<h1>PRIVATE MOTHERFUCKER</h1>";
    }
}
