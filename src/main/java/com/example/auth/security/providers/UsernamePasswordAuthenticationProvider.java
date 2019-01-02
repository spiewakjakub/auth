package com.example.auth.security.providers;

import com.example.auth.entities.User;
import com.example.auth.security.TokenAuthentication;
import com.example.auth.services.TokenService;
import com.example.auth.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class UsernamePasswordAuthenticationProvider implements AuthenticationProvider {
    private final UserService userService;
    private final TokenService tokenService;

    @Autowired
    public UsernamePasswordAuthenticationProvider(UserService userService, TokenService tokenService) {
        this.userService = userService;
        this.tokenService = tokenService;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userService.getByUsernameAnePassword(username, password)
                .orElseThrow(() -> new BadCredentialsException("Cannot log in by: " + username + "!"));

        String token = TokenService.generateNewToken();
        TokenAuthentication resultOfAuthentication = new TokenAuthentication(user, token);
        tokenService.store(user, token);

        return resultOfAuthentication;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(aClass);
    }
}
