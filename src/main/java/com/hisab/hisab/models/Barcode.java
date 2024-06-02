package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Barcode extends BaseModel {
    private String code;

    @ManyToOne
    private Shop shop;
}
