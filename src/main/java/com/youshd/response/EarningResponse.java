package com.youshd.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EarningResponse {
    private int userId;
    private String userName;
    private double discount;
    private double cashback;
    private double totalEarning;
}
