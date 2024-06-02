package com.hisab.hisab.controllers;

import com.hisab.hisab.dtos.GeneralProductDto;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.Product;
import com.hisab.hisab.repositories.ProductRepository;
import com.hisab.hisab.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

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
    public GeneralProductDto addNewProduct(@RequestBody GeneralProductDto requestDto) throws ResourceAlreadyExistsException {
        Product product = productService.addNewProduct(requestDto);
        GeneralProductDto responseDto = productToNewProductRequestDto(product);
        return responseDto;
    }

    @GetMapping("/products/barcode")
    public List<GeneralProductDto> getAllProductsByBarCode(@RequestParam("barcode") String barcode,
                                                           @RequestParam("shop_id") Long shopId) {
        List<Product> products = productRepository.findAllByBarcode_CodeAndShop_Id(barcode, shopId);

        if(products.isEmpty()) {
            return null;
        }

        List<GeneralProductDto> responseList = new ArrayList<>();
        for(Product product : products) {
            GeneralProductDto responseDto = productToNewProductRequestDto(product);
            responseList.add(responseDto);
        }

        return responseList;
    }

    @DeleteMapping("/products/{id}")
    public void deleteProductById(@PathVariable("id") Long productId) {
        productService.deleteProductById(productId);
    }

    @GetMapping("/products/shop/{id}")
    public List<GeneralProductDto> getAllProductsByShopId(@PathVariable("id") Long shopId) {
        List<Product> products = productService.getProductsByShop(shopId);
        List<GeneralProductDto> responseList = new ArrayList<>();
        for(Product product : products) {
            GeneralProductDto responseDto = productToNewProductRequestDto(product);
            responseList.add(responseDto);
        }
        return responseList;
    }

    public GeneralProductDto productToNewProductRequestDto(Product product) {
        GeneralProductDto newProductRequestDto = new GeneralProductDto();
        newProductRequestDto.setId(product.getId());
        newProductRequestDto.setName(product.getName());
        newProductRequestDto.setMrp(product.getMrp());
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
