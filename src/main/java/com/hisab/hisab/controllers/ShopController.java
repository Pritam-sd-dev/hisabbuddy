package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.NewShopRequestDto;
import com.hisab.hisab.dtos.NewShopResponseDto;
import com.hisab.hisab.models.Shop;
import com.hisab.hisab.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopController {

    ShopService shopService;

    @Autowired
    ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    public NewShopResponseDto addNewShop(@RequestBody NewShopRequestDto requestDto) throws Exception {
        Shop shop = shopService.addNewShop(
                        requestDto.getShopName(),
                        requestDto.getPhone(),
                        requestDto.getOwnerId(),
                        requestDto.getOpensAt(),
                        requestDto.getClosesAt()
                    );

        NewShopResponseDto responseDto = new NewShopResponseDto();
        responseDto.setShopName(shop.getName());
        responseDto.setShopId(shop.getId());
        responseDto.setClosesAt(shop.getClosesAt());
        responseDto.setOpensAt(shop.getOpensAt());

        return responseDto;
    }

}
