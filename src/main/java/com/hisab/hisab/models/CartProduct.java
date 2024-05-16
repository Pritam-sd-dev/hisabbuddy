package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartProduct {

    private int quantity;
    private int discount;
    private Product product;
}
