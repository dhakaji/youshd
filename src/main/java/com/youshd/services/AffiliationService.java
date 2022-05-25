package com.youshd.services;

import com.youshd.dao.*;
import com.youshd.entities.*;
import com.youshd.enums.OrderStatus;
import com.youshd.response.EarningResponse;
import com.youshd.response.OrderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AffiliationService {

    @Autowired
    private EarningRepository earningRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AffiliateLinkRepository affiliateLinkRepository;

    public OrderResponse placeOrder(User user, Product product, String affiliateLink) {
        double discount = 0;
        if(affiliateLink != null && isEligibleForBigDiscount(affiliateLink)) {
            discount = 0.2;
        } else if(affiliateLink != null) discount = 0.1;
        Orders order = new Orders(user.getUserId(), affiliateLink, product.getProductId(), product.getPrice(), discount, OrderStatus.SUCCESS);
        updateAffiliateLink(user, product);
        updateEarnings(user, product, affiliateLink, discount * product.getPrice(), discount * product.getPrice());
        orderRepository.save(order);
        return new OrderResponse(order.getOrderId(), order.getOrderStatus(), "");
    }

    private void updateAffiliateLink(User user, Product product) {
        String affiliateLink = getAffiliateLink(user, product);
        if(affiliateLink == null) {
            AffiliateLink affiliateLink1 = new AffiliateLink(user.getUserId(), product.getProductId(), generateAffiliateLink(user, product));
            affiliateLinkRepository.save(affiliateLink1);
        }
    }

    private void updateEarnings(User user, Product product, String affiliateLink, double discount, double cashback) {
        if(affiliateLink != null) {
            User affiliateUser = getAffiliateUser(affiliateLink);
            if(affiliateUser != null) {
                Earning affiliateUserEarning = earningRepository.findById(affiliateUser.getUserId()).orElse(null);
                if(affiliateUserEarning == null) {
                    affiliateUserEarning = new Earning(affiliateUser.getUserId(), product.getProductId(), 0, 0);
                }
                affiliateUserEarning.setCashback(affiliateUserEarning.getCashback() + cashback);
                earningRepository.save(affiliateUserEarning);
            }
        }
        Earning userEarning = earningRepository.findById(user.getUserId()).orElse(null);
        if(userEarning == null)
            userEarning = new Earning(user.getUserId(), product.getProductId(), 0, 0);
        userEarning.setDiscount(userEarning.getDiscount() + discount);
        earningRepository.save(userEarning);
    }

    private User getAffiliateUser(String affiliateLink) {
        if(affiliateLink == null)
            return null;
        AffiliateLink affiliateLinkDetails = affiliateLinkRepository.findFirstByAffiliateLink(affiliateLink);
        if(affiliateLinkDetails != null)
        {
            return userRepository.findById(affiliateLinkDetails.getUserId()).orElse(null);
        }
        return null;
    }

    public OrderResponse cancelOrder(Orders order) {
        if(isValidOrder(order)) {
            order.setOrderStatus(OrderStatus.CANCELLED);
            adjustDiscountAndCashBackOnCancellation(order);
        }
        return new OrderResponse(order.getOrderId(), order.getOrderStatus(), "Order cancelled");
    }

    private void adjustDiscountAndCashBackOnCancellation(Orders order) {
        User affiliateUser = getAffiliateUser(order.getAffiliateLink());
        User user = userRepository.findById(order.getUserId()).orElse(null);
        if(user != null) {
            Earning userEarnings = earningRepository.findFirstByUserIdAndProductId(user.getUserId(), order.getProductId());
            userEarnings.setDiscount(0);
            userEarnings.setCashback(0);
            earningRepository.save(userEarnings);
        }
        if(affiliateUser != null) {
            Earning affiliateUserEarnings = earningRepository.findFirstByUserIdAndProductId(affiliateUser.getUserId(), order.getProductId());
            if(order.getDiscount() == 0.2) {
                affiliateUserEarnings.setCashback(affiliateUserEarnings.getCashback() - 0.2 * order.getActualOrderPrice());
                Orders nextOrder = findNextAffiliateOrder(affiliateUser, order.getAffiliateLink());
                if(nextOrder != null) {
                    affiliateUserEarnings.setCashback(affiliateUserEarnings.getCashback() + 0.1 * order.getActualOrderPrice());
                }
            } else if(order.getDiscount() == 0.1) {
                affiliateUserEarnings.setCashback(affiliateUserEarnings.getCashback() - 0.1 * order.getActualOrderPrice());
            }
            earningRepository.save(affiliateUserEarnings);
        }
    }

    private Orders findNextAffiliateOrder(User user, String affiliateLink) {
//        List<Order> orderList = orderRepository.findByAffiliateLinkAndOrderStatusEqualsOrderByTimestamp(affiliateLink, OrderStatus.SUCCESS);
        List<Orders> orderList = orderRepository.findByAffiliateLinkAndOrderStatusEquals(affiliateLink, OrderStatus.SUCCESS);
        if(orderList.size() > 0)
            return orderList.get(0);
        return null;
    }

    private boolean isEligibleForBigDiscount(String affiliateLink) {
        AffiliateLink affiliateLink1 = affiliateLinkRepository.findFirstByAffiliateLink(affiliateLink);
        List<Orders> userOrders = orderRepository.findByUserId(affiliateLink1.getUserId());
        List<Orders> orderList = orderRepository.findByAffiliateLink(affiliateLink);
        return userOrders.size() > 0 && userOrders.get(0).getAffiliateLink() == null && OrderStatus.SUCCESS.equals(userOrders.get(0).getOrderStatus()) && orderList.size() == 0;
    }

    public String getAffiliateLink(User user, Product product) {
        List<AffiliateLink> list = affiliateLinkRepository.findByUserIdAndProductId(user.getUserId(), product.getProductId());
        return list != null && list.size() > 0 ? list.get(0).getAffiliateLink() : null;
    }

    public String generateAffiliateLink(User user, Product product) {
        return "affiliateLink:" + user.getUserId() + ":" + product.getProductId();
    }


    private boolean isValidOrder(Orders order) {
        return order != null && order.getOrderStatus() == OrderStatus.SUCCESS;
    }

    public List<EarningResponse> getAllEarnings() {
        List<User> allUsers = new ArrayList<>();
        userRepository.findAll().forEach(allUsers::add);
        List<EarningResponse> responseList = new ArrayList<>();
        for(User user : allUsers) {
            responseList.add(getUserEarning(user));
        }
        return responseList;
    }
    public EarningResponse getUserEarning(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null)
            return null;
        return getUserEarning(user);
    }

    public EarningResponse getUserEarning(User user) {
        List<Earning> earnings = earningRepository.findByUserId(user.getUserId());
        double cashback = 0;
        double discount = 0;
        for(Earning earning : earnings) {
            cashback += earning.getCashback();
            discount += earning.getDiscount();
        }
        EarningResponse earningResponse = new EarningResponse(user.getUserId(), user.getUserName(), discount, cashback, discount + cashback);
        return earningResponse;
    }

}
