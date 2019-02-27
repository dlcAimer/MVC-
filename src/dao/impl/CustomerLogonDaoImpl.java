package dao.impl;

import dao.CustomerLogonDao;
import entity.CustomerLogon;
import util.JdbcUtil;

import java.sql.*;

/**
 * Created by 29252 on 2017/7/20.
 */
public class CustomerLogonDaoImpl implements CustomerLogonDao{

    private JdbcUtil util;

    public CustomerLogonDaoImpl() {this.util = new JdbcUtil();
    }

    @Override
    public CustomerLogon add(CustomerLogon customerLogon) {
        if (exists(customerLogon.getUserName()))
            return null;

        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "INSERT INTO art.customerlogon(UserName,Pass,State,DateJoined,DateLastModified)" +
                " VALUES (?,MD5(?),?,?,?)";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, customerLogon.getUserName());
            pst.setString(2, customerLogon.getPass());
            pst.setInt(3, customerLogon.getState());
            pst.setTimestamp(4, customerLogon.getDateJoined());
            pst.setTimestamp(5, customerLogon.getDateLastModified());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        // with id
        return flag ? getOne(customerLogon.getUserName(), customerLogon.getPass()): null;
    }

    @Override
    public void delete(int customerId) {
        Connection conn = util.getConnection();
        String sql = "DELETE FROM art.customerlogon WHERE CustomerID = ?";
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, customerId);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
    }

    @Override
    public CustomerLogon update(CustomerLogon customerLogon) {
        Connection conn = util.getConnection();
        String sql = "UPDATE art.customerlogon " +
                "SET UserName = ?,State = ?, DateJoined = ?, DateLastModified = ?" +
                "WHERE CustomerID = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, customerLogon.getUserName());
            pst.setInt(2, customerLogon.getState());
            pst.setTimestamp(3, customerLogon.getDateJoined());
            pst.setTimestamp(4, new Timestamp(System.currentTimeMillis()));
            pst.setInt(5, customerLogon.getCustomerId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return flag ? customerLogon: null;
    }

    @Override
    public boolean updatePassword(int customerId, String newPass) {
        Connection conn = util.getConnection();
        String sql = "UPDATE art.customerlogon SET Pass = MD5(?) WHERE CustomerID = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, newPass);
            pst.setInt(2, customerId);
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return flag;
    }

    @Override
    public CustomerLogon getOne(String userName, String pass) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.customerlogon WHERE UserName = ? AND Pass = MD5(?)";
        PreparedStatement pst = null;
        ResultSet rs = null;
        CustomerLogon customerLogon = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, userName);
            pst.setString(2, pass);
            rs = pst.executeQuery();
            if (rs.next()) {
                customerLogon = new CustomerLogon(rs.getInt("CustomerID"),
                        rs.getString("UserName"),
                        rs.getInt("State"), rs.getTimestamp("DateJoined"),
                        rs.getTimestamp("DateLastModified"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return customerLogon;
    }

    @Override
    public boolean exists(String userName) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.customerlogon WHERE UserName = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean flag = false;
        CustomerLogon customerLogon = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, userName);
            rs = pst.executeQuery();
            if (rs.next()) {
                flag =true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return flag;
    }

    @Override
    public CustomerLogon getOne(int customerId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.customerlogon WHERE CustomerID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        CustomerLogon customerLogon = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, customerId);
            rs = pst.executeQuery();
            if (rs.next()) {
                customerLogon = new CustomerLogon(rs.getInt("CustomerID"),
                        rs.getString("UserName"),
                        rs.getInt("State"), rs.getTimestamp("DateJoined"),
                        rs.getTimestamp("DateLastModified"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return customerLogon;
    }
}
