package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.NewProductRequestDto;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Product;
import com.hisab.hisab.repositories.ProductRepository;
import com.hisab.hisab.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public void addNewProduct(NewProductRequestDto requestDto) throws ResourceAlreadyExistsException {
        Product product = productService.addNewProduct(requestDto);
    }


    public NewProductRequestDto productToNewProductRequestDto(Product product) {
        NewProductRequestDto newProductRequestDto = new NewProductRequestDto();
        newProductRequestDto.setName(product.getName());
        newProductRequestDto.setPrice(product.getPrice());
        newProductRequestDto.setQuantity(product.getQuantity());
        newProductRequestDto.setQuantity(product.getQuantity());
        newProductRequestDto.setPrice(product.getPrice());
        return newProductRequestDto;
    }

}
