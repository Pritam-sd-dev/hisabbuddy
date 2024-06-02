package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class GeneralProductDto {
    private Long id;
    private String name;
    private int price;
    private int sellingPrice;
    private int purchasePrice;
    private int minQuantity;
    private int quantity;
    private int packingTime;
    private LocalDate manufacturedDate;
    private LocalDate expiryDate;
    private LocalDate purchasedDate;
    private String barcode;
    private long categoryId;
    private long variantId;
    private long unitId;
    private long shopId;
    private String unitName;
}
