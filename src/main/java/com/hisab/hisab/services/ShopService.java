package com.hisab.hisab.services;

import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.models.Shop;
import com.hisab.hisab.models.User;
import com.hisab.hisab.repositories.ShopRepository;
import com.hisab.hisab.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

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

    @PreAuthorize("hasRole('ROLE_ADMIN') or hasAuthority('PRODUCT_OPERATION')")
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

}
