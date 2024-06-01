package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Unit extends BaseModel {
    String name;
}
