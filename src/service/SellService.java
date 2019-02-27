package service;

import entity.Onesorder;
import entity.Cart;

import java.util.List;

/**
 * Created by 29252 on 2017/7/21.
 */
public interface SellService {
//    将艺术品添加进购物车
    Cart addCart(int customerId,int artworkId,String artworkTitle);

//    从购物车中删除艺术品
    void deleteCart(int cartId);

//    得到用户购物车中所有艺术品
    List<Cart> getAll(int customerId);

//    创建一个新订单
    Onesorder addOrder(Cart cart);

//    得到用户的所有订单
    List<Onesorder> getAllOrders(int customerId);

//    判断某艺术品是否在某用户的订单中
    boolean ifin(int artworkId,int customerId);
}
