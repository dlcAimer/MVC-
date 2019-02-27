package dao;

import entity.CustomerLogon;

public interface CustomerLogonDao {

    /**
     * maybe used for register
     * @param customerLogon
     * @return
     */
    CustomerLogon add(CustomerLogon customerLogon);

//    删除登录信息
    void delete(int customerId);

//    更新登陆信息
    CustomerLogon update(CustomerLogon customerLogon);

//    是否能更新密码为新密码
    boolean updatePassword(int customerId, String newPass);

    /**
     *  maybe used for login
     * @param userName
     * @param pass
     * @return
     */

//    得到一组用户名和密码对应的登陆信息
    CustomerLogon getOne(String userName, String pass);

//    判断用户名是否存在
    boolean exists(String userName);

//    得到一个用户序号对应的登陆信息
    CustomerLogon getOne(int customerId);
}
