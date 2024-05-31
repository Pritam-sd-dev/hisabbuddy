package com.hisab.hisab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class User extends BaseModel {
    private String name;
    private String phone;

    private int age;

    // important
    @OneToOne(cascade = {CascadeType.REMOVE})
    private Image image;

    @OneToMany(mappedBy = "user")
    private List<Credit> credits;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;
}
