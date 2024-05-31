package com.hisab.hisab.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Product extends BaseModel {
    private String name;
    private int price;
    private int sellingPrice;
    private int purchasePrice;
    private Date manufacturedDate;
    private Date expiryDate;
    private Date purchasedDate;

    @ManyToOne
    private Barcode barcode;
    private int quantity;
    private int minQuantity;

    @ManyToOne
    private Category category;

    @ManyToOne
    private Variant variant;

    private int packingTime;

    @OneToOne
    private Unit unit;

    @OneToMany
    private List<Image> images;

    @ManyToOne
    private Shop shop;
}
