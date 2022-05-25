package com.youshd.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Earning {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int userId;
    private int productId;
    private double cashback;
    private double discount;
    public Earning(int userId, int productId, double cashback, double discount) {
        this.userId = userId;
        this.productId = productId;
        this.cashback = cashback;
        this.discount = discount;
    }
}
