package com.hisab.hisab.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment extends BaseModel {
    private String referenceId;

    @Enumerated(EnumType.ORDINAL)
    private PaymentType type;
    private int amount;

    @ManyToOne
    private User user;
}
