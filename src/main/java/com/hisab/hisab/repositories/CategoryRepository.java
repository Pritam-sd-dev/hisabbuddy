package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Category save(Category category);

    Optional<Category> findByNameAndShopId(String name, Long shopId);

    // important
//    @Query(value = "select * from categories where name = :name and shop_id= :id", nativeQuery = true)
//    Category findCategory(String name, Long id);
}
