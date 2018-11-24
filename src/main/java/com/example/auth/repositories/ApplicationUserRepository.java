package com.example.auth.repositories;

import com.example.auth.entities.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ApplicationUserRepository extends JpaRepository<ApplicationUser, Long> {

    List<ApplicationUser> findAll();

    Optional<ApplicationUser> findByUsername(String username);

    Optional<ApplicationUser> findByUsernameAndPassword(String username, String password);
}
