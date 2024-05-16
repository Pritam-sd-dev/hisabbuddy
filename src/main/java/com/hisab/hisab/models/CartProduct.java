package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class CartProduct extends BaseModel {

    private int quantity;
    private int discount;

    @ManyToOne
    private Product product;
}
