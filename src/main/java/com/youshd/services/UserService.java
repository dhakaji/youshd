package com.youshd.services;

import com.youshd.entities.Product;
import com.youshd.entities.User;

public class UserService {

//    private static UserDao userDao;
//    private static ProductDao productDao;
//
//    public static void returnProduct(int userId, int productId) {
//
//    }
//
//    public static void purchaseProduct(int userId, int productId) {
//        User user = userDao.getUser(userId);
//        user.addProduct(productId);
//    }
//
//    public static void addFirstDiscount(User user, int productId) {
//        /*
//        1. Check if user is eligible
//         */
//    }
//
//    public static double getDiscount(int userId) {
//        User user = userDao.getUser(userId);
//        double totalDiscount = 0;
//        List<Integer> childs = user.getReferrals();
//        for(int i=0;i<childs.size();i++) {
//            double discount = 0.0;
//            if(i == 0 && user.getParentUserId() == -1) {
//                discount = 0.2;
//            }
//            User childUser = userDao.getUser(childs.get(i));
//
//
//        }
//    }

//    public double getTotalDiscout() {
//        double discount = 0.0;
//        for(Order order : orderList) {
//            if(order.getStatus().equals(OrderStatus.SUCCESS) && order.getAffiliateUserId() != null) {
//                discount += 0.1 * order.getActualOrderPrice();
//            }
//        }
//        return discount;
//    }


//    public static void addAffiliateDiscount(User user, int productId) {
//        // 1. Add discount to current user
//        // 2. Add discount to parent user
//        /*
//        1. Check if it's first order
//            1. if yes, check if user is eligible for 20% discount
//                1. if yes, add 20% discount for both (user and parent)
//                2. if no, add 10% discount for user and 10% commison for parent
//
//         */
//        int parent = user.getParentUserId();
//        User parentUser = userDao.getUser(parent);
//        Product product = new Product();
//        double discount = 0.1 *  product.getPrice();
//        parentUser.addCashback(discount);
//        user.addDiscount(discount);
//    }

    public static void addAffiliate(User affiliateUser, User currentUser, Product productId) {

    }

    public static void getAffiliateCashbackForUserAndProduct(User user, Product product) {

    }

    public static void getToalDiscount(User user) {
        /*
        1. 10% discount on all products bought from someone else link
        2. 20% discount for first product if someone buy from affiliate link
         */
    }
}
