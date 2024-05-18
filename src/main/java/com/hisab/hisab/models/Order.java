package com.hisab.hisab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity(name = "orders")
@Getter
@Setter
public class Order extends BaseModel {

    private int amount;

    @OneToMany
    private List<CartProduct> cartProducts;

    @OneToMany
    private List<Payment> payments;

    @ManyToOne
    private Shop shop;

    @ManyToOne
    private User user;

    @Enumerated(EnumType.ORDINAL)
    private PaymentStatus paymentStatus;
}
