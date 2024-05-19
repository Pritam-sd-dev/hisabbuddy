package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    Optional<Category> findByNameAndShopId(String name, Long shopId);
}
