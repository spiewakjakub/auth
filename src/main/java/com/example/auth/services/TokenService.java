package com.example.auth.services;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class TokenService {
    private static final int HALF_AN_HOUR_IN_SECONDS = 30 * 60 * 1000;
    private static final int TWO_HOUR_IN_SECONDS = 2 * 60 * 60 * 1000;
    private static final Cache cache = CacheManager.getInstance().getCache("tokens_cache");


//    @Scheduled(fixedRate = HALF_AN_HOUR_IN_MILLISECONDS)
//    private void evictExpiredTokens() {
//        cache.evictExpiredElements();
//    }

    public String generateNewToken() {
        return UUID.randomUUID().toString();
    }

    public void store(String token, Authentication authentication) {
        cache.put(
                new Element(
                        token,
                        authentication,
                        HALF_AN_HOUR_IN_SECONDS,
                        TWO_HOUR_IN_SECONDS
                ));
    }

    public boolean contains(String token) {
        return Objects.nonNull(token);
    }

    public Authentication retrieve(String token) {
        return (Authentication) cache.get(token);
    }
}
