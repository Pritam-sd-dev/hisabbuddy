package com.hisab.hisab.services;

import com.hisab.hisab.dtos.NewProductRequestDto;
import com.hisab.hisab.exceptions.NotFoundException;
import com.hisab.hisab.exceptions.ResourceAlreadyExistsException;
import com.hisab.hisab.models.*;
import com.hisab.hisab.repositories.*;
import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private ProductRepository productRepository;
    private BarcodeRepository barcodeRepository;
    private CategoryRepository categoryRepository;
    private ShopRepository shopRepository;
    private UnitRepository unitRepository;
    private VariantRepository variantRepository;

    @Autowired
    public ProductService(
            ProductRepository productRepository,
            BarcodeRepository barcodeRepository,
            CategoryRepository categoryRepository,
            ShopRepository shopRepository,
            UnitRepository unitRepository,
            VariantRepository variantRepository
    ) {
        this.productRepository = productRepository;
        this.barcodeRepository = barcodeRepository;
        this.categoryRepository = categoryRepository;
        this.shopRepository = shopRepository;
        this.unitRepository = unitRepository;
        this.variantRepository = variantRepository;
    }

    public Product addNewProduct(NewProductRequestDto requestDto) throws ResourceAlreadyExistsException {

        Optional<Barcode> barcodeOptional = barcodeRepository.findByBarcode(requestDto.getBarcode());
        if(barcodeOptional.isPresent()) {
            throw new ResourceAlreadyExistsException("Barcode: "+requestDto.getBarcode()+" already exists");
        }

        Optional<Category> categoryOptional = categoryRepository.findById(requestDto.getCategoryId());
        if(categoryOptional.isEmpty()) {
            throw new NotFoundException("category not found with id: "+requestDto.getCategoryId());
        }

        Optional<Shop> shopOptional = shopRepository.findById(requestDto.getShopId());
        if(shopOptional.isEmpty()) {
            throw new NotFoundException("shop not found with id: "+requestDto.getShopId());
        }

        Optional<Unit> unitOptional = unitRepository.findById(requestDto.getUnitId());
        if(unitOptional.isEmpty()) {
            throw new NotFoundException("unit not found with id: "+requestDto.getUnitId());
        }
        Variant savedVariant = null;
        if(requestDto.getUnitId() == 0) {
            Variant newVariant = new Variant();
            savedVariant = variantRepository.save(newVariant);
        } else {
            Optional<Variant> variantOptional = variantRepository.findById(requestDto.getVariantId());
            if(variantOptional.isEmpty()) {
                throw new NotFoundException("variant not found with id: "+requestDto.getVariantId());
            }
            savedVariant = variantOptional.get();
        }

        Barcode barcode = barcodeOptional.get();
        Category category = categoryOptional.get();
        Shop shop = shopOptional.get();
        Unit unit = unitOptional.get();


        Product product = new Product();

        product.setName(requestDto.getName());
        product.setPrice(requestDto.getPrice());
        product.setSellingPrice(requestDto.getSellingPrice());
        product.setPurchasePrice(requestDto.getPurchasePrice());
        product.setQuantity(requestDto.getQuantity());
        product.setMinQuantity(requestDto.getMinQuantity());
        product.setPackingTime(requestDto.getPackingTime());
        product.setManufacturedDate(requestDto.getManufacturedDate());
        product.setExpiryDate(requestDto.getExpiryDate());
        product.setPurchasedDate(requestDto.getPurchasedDate());
        product.setBarcode(barcode);
        product.setCategory(category);
        product.setShop(shop);
        product.setUnit(unit);
        product.setVariant(savedVariant);

        Product savedProduct = productRepository.save(product);
        return savedProduct;
    }
}
