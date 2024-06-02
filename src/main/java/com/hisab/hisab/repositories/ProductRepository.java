package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    @Override
    <S extends Product> S save(S entity);

    List<Product> findAllByBarcode_CodeAndShop_Id(String code, Long shopId);

    @Override
    void deleteById(Long aLong);
}
