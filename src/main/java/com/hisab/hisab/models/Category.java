package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    private String name;
    private String image;

    @ManyToOne
    private Shop shop;
}
