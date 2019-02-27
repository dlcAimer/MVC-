package dao;

import entity.Cart;
import java.util.List;
/**
 * Created by 29252 on 2017/7/21.
 */
public interface CartDao {
//    创建一个新的购物车
    Cart add(Cart cart);

//    删除一个订单序号对应的购物车
    void delete(int cartId);

//    得到一个用户的所有购物车信息
    List<Cart> getAll(int customerId);

//    得到购物车序号所对应的购物车信息
    Cart getOne(int cartId);

//    得到一个艺术品所在的所有购物车的信息
    List<Cart> getAllByArtworkId(int artworkId);

//    判断一个艺术品是否在某个用户的购物车中
    boolean ifin(int artworkId,int customerId);
}
