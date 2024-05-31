package com.hisab.hisab.security;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class JwtData {
    private String email;
    private Long userId;
    private List<String> roles;
}
