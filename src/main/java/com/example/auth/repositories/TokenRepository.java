package com.example.auth.repositories;

import com.example.auth.entities.Token;
import com.example.auth.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface TokenRepository extends JpaRepository<Token, Long> {
    Token getTokenByToken(String token);
    Token getTokenByUser(User user);
    void deleteByCreationTimeBefore(Timestamp time);
}
