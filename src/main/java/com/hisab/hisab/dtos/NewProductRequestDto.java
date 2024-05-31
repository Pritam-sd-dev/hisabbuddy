package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NewProductRequestDto {
    private String name;
    private String barcode;
    private int price;
    private int sellingPrice;
    private int purchasePrice;
    private int minQuantity;
    private int packingTime;
    private int quantity;
    private Date manufacturedDate;
    private Date expiryDate;
    private Date purchasedDate;
    private long categoryId;
    private long variantId;
    private long unitId;
    private long shopId;
}
