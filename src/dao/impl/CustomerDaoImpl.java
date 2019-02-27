package dao.impl;

import dao.CustomerDao;
import entity.Customers;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29252 on 2017/7/20.
 */
public class CustomerDaoImpl implements CustomerDao{
    private JdbcUtil util;

    public CustomerDaoImpl() {
        this.util = new JdbcUtil();
    }

    @Override
    public Customers add(Customers customers) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "INSERT INTO art.customers(CustomerID, FirstName, LastName, Address, City, Region, Country, Postal, Phone, Email, Privacy)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?)"; // 11
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, customers.getCustomerId());
            pst.setString(2, customers.getFirstName());
            pst.setString(3, customers.getLastName());
            pst.setString(4, customers.getAddress());
            pst.setString(5, customers.getCity());
            pst.setString(6, customers.getRegion());
            pst.setString(7, customers.getCountry());
            pst.setString(8, customers.getPostal());
            pst.setString(9, customers.getPhone());
            pst.setString(10, customers.getEmail());
            pst.setString(11, customers.getPrivacy());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return flag ? customers : null;
    }

    @Override
    public void delete(int customerId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "DELETE FROM art.customers WHERE CustomerID = ?";
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
    public Customers update(Customers customers) {
        Connection conn = util.getConnection();
        // FirstName, LastName, Address, City, Region, Country, Postal, Phone, Email, Privacy)
        //language=MySQL
        String sql = "UPDATE art.customers SET FirstName = ?, LastName = ?, Address = ?, City = ?," +
                "Region = ?, Country = ?, Postal = ?, Phone = ?, Email = ?, Privacy = ? " +
                "WHERE CustomerID = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setString(1, customers.getFirstName());
            pst.setString(2, customers.getLastName());
            pst.setString(3, customers.getAddress());
            pst.setString(4, customers.getCity());
            pst.setString(5, customers.getRegion());
            pst.setString(6, customers.getCountry());
            pst.setString(7, customers.getPostal());
            pst.setString(8, customers.getPhone());
            pst.setString(9, customers.getEmail());
            pst.setString(10, customers.getPrivacy());
            pst.setInt(11, customers.getCustomerId());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return flag ? customers : null;
    }

    @Override
    public List<Customers> getAll() {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.customers";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Customers> customers = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs =  pst.executeQuery();
            while (rs.next()) {
                customers.add(buildCustomer(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return customers;
    }

    @Override
    public Customers getOne(int customerId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.customers WHERE CustomerID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Customers customers = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, customerId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                customers = buildCustomer(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return customers;
    }

    private Customers buildCustomer(ResultSet rs) throws SQLException{
        // FirstName, LastName, Address, City, Region, Country, Postal, Phone, Email, Privacy)
        return new Customers(rs.getInt("CustomerID"), rs.getString("FirstName"),
                rs.getString("LastName"), rs.getString("Address"),
                rs.getString("City"), rs.getString("Region"),
                rs.getString("Country"), rs.getString("Postal"),
                rs.getString("Phone"), rs.getString("Email"),
                rs.getString("Privacy"));
    }
}
