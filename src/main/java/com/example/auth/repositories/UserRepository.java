package com.example.auth.repositories;

import com.example.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    @Override
    Optional<User> findById(Long aLong);

    User findByUsername(String username);
}
