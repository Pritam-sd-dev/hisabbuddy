package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.NewCategoryRequestDto;
import com.hisab.hisab.dtos.NewCategoryResponseDto;
import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Category;
import com.hisab.hisab.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("categories")
    public NewCategoryResponseDto addNewCategory(@RequestBody NewCategoryRequestDto requestDto) throws NotFoundException, ResourceAlreadyExistsException {
        Category savedCategory = categoryService.addCategory(requestDto.getName(), requestDto.getImage(), requestDto.getShopId());

        NewCategoryResponseDto responseDto = new NewCategoryResponseDto();
        responseDto.setId(savedCategory.getId());
        responseDto.setName(savedCategory.getName());
        responseDto.setImageLink(savedCategory.getImage());

        return responseDto;
    }
}
