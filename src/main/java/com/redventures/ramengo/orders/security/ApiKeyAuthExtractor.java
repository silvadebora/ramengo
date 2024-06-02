package com.redventures.ramengo.orders.security;

import com.redventures.ramengo.orders.exception.ForbiddenException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class ApiKeyAuthExtractor {

    @Value("${api.key}")
    private String apiKey;

    public Optional<Authentication> extract(HttpServletRequest request){
        String providedKey = request.getHeader("x-api-key");
        if(providedKey == null || !providedKey.equals(apiKey)) {
            throw new ForbiddenException("x-api-key header missing or invalid");
        }
        return Optional.of(new ApiKeyAuth(providedKey, AuthorityUtils.NO_AUTHORITIES));
    }
}
