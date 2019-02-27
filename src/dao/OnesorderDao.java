package dao;

import entity.Onesorder;

import java.util.List;
/**
 * Created by 29252 on 2017/7/21.
 */
public interface OnesorderDao {
//    创建一个个人的订单
    Onesorder add(Onesorder onesorder);

//    从个人的订单中删除某一作品
    void delete(int onesorderId);

//    得到一个用户的所有订单
    List<Onesorder> getAll(int customerId);

//    得到某一个订单
    Onesorder getOne(int onesorderId);
}
