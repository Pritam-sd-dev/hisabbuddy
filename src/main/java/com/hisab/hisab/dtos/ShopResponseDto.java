package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShopResponseDto {
    private String shopName;
    private String phone;
    private int opensAt;
    private int closesAt;
    private long shopId;
    private long ownerId;
}
