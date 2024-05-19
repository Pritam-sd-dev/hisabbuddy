package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.ExceptionDto;
import com.hisab.hisab.dtos.NewCategoryRequestDto;
import com.hisab.hisab.dtos.NewCategoryResponseDto;
import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Category;
import com.hisab.hisab.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


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
    public ResponseEntity<ExceptionDto> handleNotFoundException(NotFoundException e) {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.NOT_FOUND, e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ResourceAlreadyExistsException.class)
    public ResponseEntity<ExceptionDto> handleResourceAlreadyExistsException(ResourceAlreadyExistsException e) {
        return new ResponseEntity<>(new ExceptionDto(HttpStatus.ALREADY_REPORTED, e.getMessage()), HttpStatus.ALREADY_REPORTED);
    }
}
