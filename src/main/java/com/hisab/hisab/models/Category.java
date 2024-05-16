package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category {
    private String name;
    private String image;
}
