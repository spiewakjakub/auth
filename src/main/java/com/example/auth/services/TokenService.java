package com.example.auth.services;

import com.example.auth.entities.Token;
import com.example.auth.entities.User;
import com.example.auth.repositories.TokenRepository;
import com.example.auth.security.TokenAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

@Component
@EnableScheduling
public class TokenService {

    private final TokenRepository tokenRepository;

    @Autowired
    public TokenService(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    private void evictExpiredTokens() {
        tokenRepository.deleteByCreationTimeBefore(new Timestamp(System.currentTimeMillis() - 10 * 1000));
    }

    public static String generateNewToken() {
        return UUID.randomUUID().toString();
    }

    public void store(User user, String token) {
        tokenRepository.save(
                new Token(
                        user,
                        token));
    }

    public boolean contains(String token) {
        return Objects.nonNull(tokenRepository.getTokenByToken(token));
    }

    public Authentication retrieve(String token) {
        Token tokenObj = tokenRepository.getTokenByToken(token);
        System.out.println(tokenObj);
        return new TokenAuthentication(
                tokenObj.getUser(),
                tokenObj.getToken());
    }

    public List<Token> getAll() {
        return tokenRepository.findAll();
    }
}
