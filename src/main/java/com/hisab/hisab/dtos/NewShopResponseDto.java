package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewShopResponseDto {
    private Long shopId;
    private String shopName;
    private int closesAt;
    private int opensAt;
}
