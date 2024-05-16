package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class User {
    private String name;
    private String phone;
    private UserType userType;
    private int age;
    private Image image;
}
