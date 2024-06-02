package com.hisab.hisab.services;

import com.hisab.hisab.models.Barcode;
import com.hisab.hisab.models.Shop;
import com.hisab.hisab.repositories.BarcodeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BarcodeService {
    BarcodeRepository barcodeRepository;

    @Autowired
    public BarcodeService(BarcodeRepository barcodeRepository) {
        this.barcodeRepository = barcodeRepository;
    }

    public Barcode createBarcode(String code, Shop shop) {
        Barcode barcode = new Barcode();
        barcode.setCode(code);
        barcode.setShop(shop);
        return barcodeRepository.save(barcode);
    }
}
