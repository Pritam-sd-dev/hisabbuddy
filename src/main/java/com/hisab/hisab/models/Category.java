package com.hisab.hisab.models;

import jakarta.persistence.*;
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

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE)
//    @Fetch(FetchMode.SELECT)
    private List<Product> products;
}
