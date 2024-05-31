package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.ExceptionDto;
import com.hisab.hisab.dtos.NewCategoryRequestDto;
import com.hisab.hisab.dtos.NewCategoryResponseDto;
import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Category;
import com.hisab.hisab.services.CategoryService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


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

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Object> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<Object> handleResourceAlreadyExistsException(ResourceAlreadyExistsException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.ALREADY_REPORTED);
    }
}
