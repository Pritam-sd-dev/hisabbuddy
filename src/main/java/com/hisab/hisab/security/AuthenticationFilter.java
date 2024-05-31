package com.hisab.hisab.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {

    TokenValidator tokenValidator;

    public AuthenticationFilter(TokenValidator tokenValidator) {
        this.tokenValidator = tokenValidator;
    }

    @Override
    protected void doFilterInternal(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain filterChain)
            throws ServletException, IOException
    {
        String token = request.getHeader("Authorization");
        if (token == null) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Set the appropriate status code
            response.setContentType("application/json");
            String jsonResponse = String.format("{\"error\": \"%s\"}", "token not present");
            response.getWriter().write(jsonResponse);
            return;
        }

        JwtData jwtData = validateToken(token);
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for(String role : jwtData.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role));
        }
        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(jwtData.getEmail(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        filterChain.doFilter(request, response);
    }

    public JwtData validateToken(String token) {
        Optional<JwtData> jwtDataOptional = this.tokenValidator.validateToken(token);
        if (jwtDataOptional.isEmpty()) {
            throw new RuntimeException("Invalid token");
        }
        return jwtDataOptional.get();
    }
}
