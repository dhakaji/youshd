package com.youshd.services;

import com.youshd.dao.*;
import com.youshd.entities.Orders;
import com.youshd.entities.Product;
import com.youshd.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DummyDataService {

    @Autowired
    private AffiliationService affiliationService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EarningRepository earningRepository;

    @Autowired
    private AffiliateLinkRepository affiliateLinkRepository;

    public void addProduct() {
        Product product = new Product(1, 100.0, "nike-shoes");
        productRepository.save(product);
    }

    public void addUsers() {
        User user1 = new User(1, "angela");
        User user2 = new User(2, "maria");
        User user3 = new User(3, "bob");
        User user4 = new User(4, "meggieB");
        User user5 = new User(5, "jimi");
        User user6 = new User(6, "hendrix");
        User user7 = new User(7, "nusrat");
        userRepository.save(user1);
        userRepository.save(user2);
        userRepository.save(user3);
        userRepository.save(user4);
        userRepository.save(user5);
        userRepository.save(user6);
        userRepository.save(user7);
        Product product = productRepository.findByProductName("nike-shoes").get(0);
        addOrders(user1, null, product);
        addOrders(user2, affiliationService.getAffiliateLink(user1, product), product);
        addOrders(user3, affiliationService.getAffiliateLink(user1, product), product);
        addOrders(user4, affiliationService.getAffiliateLink(user2, product), product);
        addOrders(user5, affiliationService.getAffiliateLink(user3, product), product);
        addOrders(user6, affiliationService.getAffiliateLink(user5, product), product);
        addOrders(user7, affiliationService.getAffiliateLink(user5, product), product);
    }

    public void addDummyData() {
        addProduct();
        addUsers();
    }

    public void removeData() {
//        userRepository.deleteAllByUserIdBefore(30);
        userRepository.deleteAll();
        orderRepository.deleteAll();
        productRepository.deleteAll();
        earningRepository.deleteAll();
        affiliateLinkRepository.deleteAll();
//        affiliationService.resetEarningId();
//        affiliationService.resetOrderId();
//        affiliationService.resetAffiliateId();
    }

    public void addOrders(User user, String affiliationLink, Product product) {
        affiliationService.placeOrder(user, product, affiliationLink);
    }

    public void cancelOrder(String userName) {
        User user = userRepository.findByUserName(userName.toLowerCase()).get(0);
        cancelOrder(user);
    }

    public void cancelOrder(User user) {
        List<Orders> order = orderRepository.findByUserId(user.getUserId());
        affiliationService.cancelOrder(order.get(0));
    }
}
