package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Shop;
import com.hisab.hisab.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findById(Long id);

    List<Shop> findAllByOwnerId(Long id);

    Shop save(Shop shop);

    @Query(value =
            "select * from shop where shop.id in " +
                    "(select shop_id from shop_access_users where access_users_id = :userId)"
            , nativeQuery = true
    )
    Optional<User> findAllByUser(Long userId);
}
