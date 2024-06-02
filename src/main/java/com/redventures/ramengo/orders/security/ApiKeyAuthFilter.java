package com.redventures.ramengo.orders.security;

import com.redventures.ramengo.orders.exception.ForbiddenException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyAuthFilter extends OncePerRequestFilter {

    @Autowired
    private ApiKeyAuthExtractor authExtractor;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try{
            authExtractor.extract(request)
                    .ifPresent(SecurityContextHolder.getContext()::setAuthentication);
            filterChain.doFilter(request, response);
        } catch(ForbiddenException ex){
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            response.setContentType("application/json");
            response.getWriter().write("{\"error\": \"" + ex.getMessage() + "\"}");
        }
    }
}
