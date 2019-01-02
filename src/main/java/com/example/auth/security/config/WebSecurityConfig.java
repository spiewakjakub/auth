package com.example.auth.security.config;

import com.example.auth.security.providers.TokenAuthenticationProvider;
import com.example.auth.security.providers.UsernamePasswordAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider;
    private final TokenAuthenticationProvider tokenAuthenticationProvider;

    @Autowired
    public WebSecurityConfig(
            UsernamePasswordAuthenticationProvider usernamePasswordAuthenticationProvider,
            TokenAuthenticationProvider tokenAuthenticationProvider) {
        this.usernamePasswordAuthenticationProvider = usernamePasswordAuthenticationProvider;
        this.tokenAuthenticationProvider = tokenAuthenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .authenticationProvider(usernamePasswordAuthenticationProvider);
        auth
                .authenticationProvider(tokenAuthenticationProvider);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/private/*").authenticated()
                .anyRequest().permitAll()
        .and()
        .httpBasic();
    }
}
