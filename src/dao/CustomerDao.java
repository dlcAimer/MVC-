package dao;

import entity.Customers;

import java.util.List;

/**
 * Created by 29252 on 2017/7/20.
 */
public interface CustomerDao {
//    添加一个用户信息
    Customers add(Customers customers);

//    删除一个用户信息
    void delete(int customerId);

//    更新一个用户信息
    Customers update(Customers customers);

//    得到所有的用户
    List<Customers> getAll();

//    得到一个用户序号对应的用户信息
    Customers getOne(int customerId);
}
