package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class NewProductRequestDto {
    private String name;
    private int price;
    private int sellingPrice;
    private int purchasePrice;
    private int minQuantity;
    private int quantity;
    private int packingTime;
    private Date manufacturedDate;
    private Date expiryDate;
    private Date purchasedDate;
    private String barcode;
    private long categoryId;
    private long variantId;
    private long unitId;
    private long shopId;
}
