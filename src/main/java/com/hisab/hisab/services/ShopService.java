package com.hisab.hisab.services;

import com.hisab.hisab.dtos.ShopResponseDto;
import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.models.Shop;
import com.hisab.hisab.models.User;
import com.hisab.hisab.repositories.ShopRepository;
import com.hisab.hisab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {
    ShopRepository shopRepository;
    UserRepository userRepository;


    @Autowired
    public ShopService(
            ShopRepository shopRepository,
            UserRepository userRepository
    ){
        this.shopRepository = shopRepository;
        this.userRepository = userRepository;
    }

    public Shop addNewShop(String shopName, String phone, Long ownerId, int opensAt, int closesAt) throws Exception {

        Optional<User> optionalUser = userRepository.findById(ownerId);

        if(optionalUser.isEmpty()) {
            throw new NotFoundException("User with id: " + ownerId + " not found");
        }

        if(opensAt >= closesAt && closesAt > 0) {
            throw new Exception("shop open_time must be smaller than close_time");
        }

        Shop shop = new Shop();
        shop.setOwner(optionalUser.get());
        shop.setName(shopName);
        shop.setPhone(phone);
        shop.setOpensAt(opensAt);
        shop.setClosesAt(closesAt);

        return shopRepository.save(shop);
    }

    public List<ShopResponseDto> getAllShopByOwner(Long ownerId) throws Exception {
        List<Shop> shops = shopRepository.findAllByOwnerId(ownerId);
        
        List<ShopResponseDto> responseDtos = new ArrayList<>();
        for(Shop shop : shops) {
            ShopResponseDto responseDto = new ShopResponseDto();
            responseDto.setShopName(shop.getName());
            responseDto.setPhone(shop.getPhone());
            responseDto.setOpensAt(shop.getOpensAt());
            responseDto.setClosesAt(shop.getClosesAt());
            responseDto.setOwnerId(shop.getOwner().getId());
            responseDto.setShopId(shop.getId());
            responseDtos.add(responseDto);
        }
        return responseDtos;
    }

}
