package com.hisab.hisab.services;

import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Category;
import com.hisab.hisab.models.Product;
import com.hisab.hisab.models.Shop;
import com.hisab.hisab.repositories.CategoryRepository;
import com.hisab.hisab.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
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

    public Category addCategory(String name, String imageLink, Long shopId) throws ResourceAlreadyExistsException {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);

        if(shopOptional.isEmpty()) {
            throw new NotFoundException("Shop with id: " + shopId + " not present");
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

    public void getProductList(List<String> ids) {
        List<Long> catIds = ids.stream().map(Long::valueOf).toList();
        List<Category> categories = categoryRepository.findAllById(catIds);

        for(Category category : categories) {
            for(Product product : category.getProducts()) {
                System.out.println(product.getBarcode());
            }
        }
    }

    public void deleteCategory(Long id) {
        categoryRepository.deleteById(id);
    }
}
