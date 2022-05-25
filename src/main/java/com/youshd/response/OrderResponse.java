package com.youshd.response;

import com.youshd.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderResponse {
    private int orderId;
    private OrderStatus orderStatus;
    private String message;
}
