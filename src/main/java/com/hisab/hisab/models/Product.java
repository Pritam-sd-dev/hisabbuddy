package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
public class Product {
    private String name;
    private int price;
    private int sellingPrice;
    private int purchasePrice;
    private Date manufacturedDate;
    private Date expiryDate;
    private Date purchasedDate;
    private Barcode barcode;
    private int quantity;
    private int minQuantity;
    private Category category;
    private Variant variant;
    private int packingTime;
    private Unit unit;
    private List<Image> images;
    private Shop shop;
}
