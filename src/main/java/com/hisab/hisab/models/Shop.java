package com.hisab.hisab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Shop extends BaseModel {
    private int opensAt;
    private int closesAt;
    private String phone;

    @OneToMany(mappedBy = "shop")
    private List<Product> products;

    @ManyToMany
    private List<User> users;

    @OneToMany(mappedBy = "shop")
    private List<Order> orders;

    @OneToMany(mappedBy = "shop")
    private List<Category> categories;

    @OneToMany
    private List<Credit> credits;

    @ElementCollection
    @Enumerated(EnumType.ORDINAL)
    private List<PaymentType> paymentTypes;

    @OneToMany
    private List<Party> parties;
}
