package com.hisab.hisab.services;

import com.hisab.hisab.models.Category;
import com.hisab.hisab.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category addCategory(String name, String imageLink) {
        Category newCategory = new Category();
        newCategory.setImage(imageLink);
        newCategory.setName(name);

        return  categoryRepository.save(newCategory);
    }
}
