package com.hisab.hisab.controllers;

import com.hisab.hisab.models.Product;
import com.hisab.hisab.repositories.ProductRepository;
import com.hisab.hisab.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    @PostMapping("/products")
    public void addNewProduct(Product product) {

    }

}
