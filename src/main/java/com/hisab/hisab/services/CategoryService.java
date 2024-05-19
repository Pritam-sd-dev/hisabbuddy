package com.hisab.hisab.services;

import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Category;
import com.hisab.hisab.models.Shop;
import com.hisab.hisab.repositories.CategoryRepository;
import com.hisab.hisab.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;
    ShopRepository shopRepository;

    @Autowired
    public CategoryService(
            CategoryRepository categoryRepository,
            ShopRepository shopRepository
    ) {
        this.categoryRepository = categoryRepository;
        this.shopRepository = shopRepository;
    }

    public Category addCategory(String name, String imageLink, Long shopId) throws NotFoundException, ResourceAlreadyExistsException {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);

        if(shopOptional.isEmpty()) {
            throw new NotFoundException("Shop not found with id: " + shopId);
        }

        Optional<Category> categoryOptional = categoryRepository.findByNameAndShopId(name, shopId);

        if(categoryOptional.isPresent()) {
            throw new ResourceAlreadyExistsException("Category with name: " + name + " already exists");
        }

        Shop shop = shopOptional.get();

        Category newCategory = new Category();
        newCategory.setShop(shop);
        newCategory.setImage(imageLink);
        newCategory.setName(name);

        return  categoryRepository.save(newCategory);
    }
}
