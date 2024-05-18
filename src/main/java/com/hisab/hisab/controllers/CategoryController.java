package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.NewCategoryResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    @PostMapping("categories")
    public NewCategoryResponseDto addNewCategory() {
        return null;
    }
}
