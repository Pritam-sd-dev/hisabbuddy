package com.hisab.hisab.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NewCategoryRequestDto {
    private String name;
    private String image;
    private Long shopId;
}
