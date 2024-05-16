package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    private String referenceId;
    private PaymentType type;
    private int amount;
    private User user;
}
