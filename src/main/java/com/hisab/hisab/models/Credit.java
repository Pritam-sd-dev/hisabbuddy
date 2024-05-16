package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Credit extends BaseModel {
    private int amount;
    private Date date;

    @ManyToOne
    private User user;
}
