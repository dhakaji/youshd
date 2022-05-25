package com.youshd.entities;

import com.youshd.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private int userId;
    private String affiliateLink;
    private int productId;
    private double actualOrderPrice;
    private double discount;
    private OrderStatus orderStatus;
    private Timestamp timestamp;

    public Orders(int userId, String affiliateLink, int productId, double actualOrderPrice, double discount,
          OrderStatus orderStatus) {
        this.userId = userId;
        this.affiliateLink = affiliateLink;
        this.productId = productId;
        this.actualOrderPrice = actualOrderPrice;
        this.discount = discount;
        this.orderStatus = orderStatus;
        this.timestamp = new Timestamp(System.currentTimeMillis());
    }
}
