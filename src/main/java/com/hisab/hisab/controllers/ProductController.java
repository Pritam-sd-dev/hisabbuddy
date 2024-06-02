package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.NewProductRequestDto;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Product;
import com.hisab.hisab.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/products")
    public NewProductRequestDto addNewProduct(@RequestBody NewProductRequestDto requestDto) throws ResourceAlreadyExistsException {
        Product product = productService.addNewProduct(requestDto);
        NewProductRequestDto responseDto = productToNewProductRequestDto(product);
        return responseDto;
    }


    public NewProductRequestDto productToNewProductRequestDto(Product product) {
        NewProductRequestDto newProductRequestDto = new NewProductRequestDto();
        newProductRequestDto.setId(product.getId());
        newProductRequestDto.setName(product.getName());
        newProductRequestDto.setPrice(product.getPrice());
        newProductRequestDto.setSellingPrice(product.getSellingPrice());
        newProductRequestDto.setPurchasePrice(product.getPurchasePrice());
        newProductRequestDto.setMinQuantity(product.getMinQuantity());
        newProductRequestDto.setQuantity(product.getQuantity());
        newProductRequestDto.setPackingTime(product.getPackingTime());
        newProductRequestDto.setManufacturedDate(product.getManufacturedDate());
        newProductRequestDto.setExpiryDate(product.getExpiryDate());
        newProductRequestDto.setPurchasedDate(product.getPurchasedDate());
        newProductRequestDto.setBarcode(product.getBarcode().getCode());
        newProductRequestDto.setCategoryId(product.getCategory().getId());
        newProductRequestDto.setVariantId(product.getVariant().getId());
        newProductRequestDto.setShopId(product.getShop().getId());
        newProductRequestDto.setUnitId(product.getUnit().getId());
        newProductRequestDto.setUnitName(product.getUnit().getName());
        return newProductRequestDto;
    }

}
