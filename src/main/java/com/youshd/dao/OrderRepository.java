package com.youshd.dao;

import com.youshd.entities.Orders;
import com.youshd.enums.OrderStatus;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders, Integer> {
    List<Orders> findByAffiliateLink(String affiliateLink);
    List<Orders> findByAffiliateLinkAndOrderStatusEquals(String affiliateLink, OrderStatus orderStatus);
    List<Orders> findByUserId(int userId);
}
