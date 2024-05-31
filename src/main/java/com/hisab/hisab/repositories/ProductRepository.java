package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
