package com.example.auth.services;

import com.example.auth.entities.ApplicationUser;
import com.example.auth.repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ApplicationUserService {

    private final ApplicationUserRepository applicationUserRepository;

    @Autowired
    public ApplicationUserService(ApplicationUserRepository applicationUserRepository) {
        this.applicationUserRepository = applicationUserRepository;
    }

    public Optional<ApplicationUser> getById(Long id) {
        return applicationUserRepository.findById(id);
    }

    public Optional<ApplicationUser> getByUsername(String username) {
        return applicationUserRepository.findByUsername(username);
    }

    public Optional<ApplicationUser> getByUsernameAnePassword(String username, String password) {
        return applicationUserRepository.findByUsernameAndPassword(username, password);
    }

    public List<ApplicationUser> getAll() {
        return applicationUserRepository.findAll();
    }

    public Optional<ApplicationUser> save(ApplicationUser user) {
        return Optional.of(applicationUserRepository.save(user));
    }
}
