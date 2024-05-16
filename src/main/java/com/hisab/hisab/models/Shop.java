package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Shop {
    private List<Product> products;
    private List<User> users;
    private int opensAt;
    private int closesAt;
    private List<Order> orders;
    private List<Category> categories;
    private List<Credit> credits;
    private List<PaymentType> paymentTypes;
    private List<Party> parties;
}
