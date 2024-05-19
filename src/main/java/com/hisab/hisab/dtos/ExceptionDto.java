package com.hisab.hisab.dtos;

import org.springframework.http.HttpStatus;

public class ExceptionDto {
    private HttpStatus httpStatus;
    private String message;

    public ExceptionDto(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
