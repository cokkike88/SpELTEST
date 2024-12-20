package com.omunoz.SpELTest.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class DiscountRule {

    @Id
    @GeneratedValue
    private Long id;
    private String condition; // SpEL condition
    private double discountPercentage;

    public DiscountRule(String condition, double discountPercentage) {
        this.condition = condition;
        this.discountPercentage = discountPercentage;
    }

}
