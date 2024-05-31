package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.List;

@Entity
@Getter
@Setter
public class Category extends BaseModel {
    private String name;
    private String image;

    @ManyToOne
    private Shop shop;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
//    @Fetch(FetchMode.SELECT)
    private List<Product> products;
}
