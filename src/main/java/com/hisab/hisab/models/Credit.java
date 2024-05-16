package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
public class Credit {
    private int amount;
    private Date date;
    private User user;
}
