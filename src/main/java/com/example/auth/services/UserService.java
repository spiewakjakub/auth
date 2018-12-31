package com.example.auth.services;

import com.example.auth.entities.User;
import com.example.auth.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Optional<User> getById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> getByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Optional<User> getByUsernameAnePassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

    public boolean isExist(String username, String password) {
        return userRepository.existsUserByUsernameAndPassword(username, password);
    }
}
