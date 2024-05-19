package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewShopRequestDto {
    private String shopName;
    private Long ownerId;
    private int opensAt;
    private int closesAt;
}
