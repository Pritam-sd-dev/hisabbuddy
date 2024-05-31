package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.NewShopRequestDto;
import com.hisab.hisab.dtos.NewShopResponseDto;
import com.hisab.hisab.dtos.ShopResponseDto;
import com.hisab.hisab.models.Shop;
import com.hisab.hisab.security.JwtData;
import com.hisab.hisab.security.TokenValidator;
import com.hisab.hisab.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ShopController {

    private ShopService shopService;
    private TokenValidator tokenValidator;

    @Autowired
    ShopController(ShopService shopService, TokenValidator tokenValidator) {
        this.shopService = shopService;
        this.tokenValidator = tokenValidator;
    }

    @PostMapping("/shops")
    public NewShopResponseDto addNewShop(
            @RequestBody NewShopRequestDto requestDto
    ) throws Exception {
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

    @GetMapping("/shops")
    public List<ShopResponseDto> getAllShopsByOwnerId(@RequestParam Long ownerId) throws Exception {
        return shopService.getAllShopByOwner(ownerId);
    }
}
