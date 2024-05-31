package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Long> {
    Optional<Shop> findById(Long id);

    List<Shop> findAllByOwnerId(Long id);

    Shop save(Shop shop);
}
