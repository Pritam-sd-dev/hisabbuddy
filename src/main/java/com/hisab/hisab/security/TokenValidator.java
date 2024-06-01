package com.hisab.hisab.security;

import com.hisab.hisab.dtos.ValidateRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class TokenValidator {

    private RestTemplate restTemplate;

    @Autowired
    public TokenValidator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Optional<JwtData> validateToken(String token) {
        ValidateRequestDto requestDto = new ValidateRequestDto();
        requestDto.setToken(token);
        ResponseEntity<JwtData> responseEntity = restTemplate.postForEntity("http://localhost:9000/auth/validate", requestDto, JwtData.class);
        return Optional.ofNullable(responseEntity.getBody());
    }
}
