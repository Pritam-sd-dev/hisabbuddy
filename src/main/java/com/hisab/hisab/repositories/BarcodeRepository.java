package com.hisab.hisab.repositories;

import com.hisab.hisab.models.Barcode;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BarcodeRepository extends JpaRepository<Barcode, Long> {
    Optional<Barcode> findByBarcode(String barcode);
}
