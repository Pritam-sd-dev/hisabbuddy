package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Order {
    private User user;
    private List<CartProduct> cartProducts;
    private Shop shop;
    private int amount;
    private PaymentStatus paymentStatus;
    private List<Payment> payments;
}
