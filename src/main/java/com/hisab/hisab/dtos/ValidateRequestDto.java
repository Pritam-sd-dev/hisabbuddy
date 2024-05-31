package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ValidateRequestDto {
    private String token;
    private Long userId;
}
