package dao.impl;

import dao.CartDao;
import entity.Cart;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by 29252 on 2017/7/21.
 */
public class CartDaoImpl implements CartDao{
    private JdbcUtil util;

    public CartDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public Cart add(Cart cart) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "INSERT INTO art.cart (OrderID, CustomerID, ArtworkID, DateCreate, ArtworkTitle)" +
                " VALUES (?,?,?,?,?)"; // 11
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cart.getOrderId());
            pst.setInt(2, cart.getCustomerId());
            pst.setInt(3, cart.getArtworkId());
            pst.setString(4, cart.getDateCreate());
            pst.setString(5, cart.getArtworkTitle());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return flag ? cart : null;
    }

    @Override
    public void delete(int cartID) {
        Connection conn = util.getConnection();
        //language=MySQL
        if (getOne(cartID) != null) {
            String sql = "DELETE FROM art.cart WHERE OrderID = ?";
            PreparedStatement pst = null;
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, cartID);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                util.close(null, pst, conn);
            }
        }
    }

    @Override
    public List<Cart> getAll(int customerId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.cart WHERE CustomerID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cart> carts = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, customerId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                carts.add(buildCart(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return carts;
    }

    @Override
    public Cart getOne(int cartId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.cart WHERE OrderID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cart cart = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, cartId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                cart = buildCart(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return cart;
    }

    @Override
    public List<Cart> getAllByArtworkId(int artworkId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.cart WHERE ArtworkID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Cart> carts = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, artworkId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                carts.add(buildCart(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return carts;
    }

    @Override
    public boolean ifin(int artworkId, int customerId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.cart WHERE ArtworkID = ? AND CustomerID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Cart cart = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, artworkId);
            pst.setInt(2, customerId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                cart = buildCart(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }

        return cart != null;
    }

    private Cart buildCart(ResultSet rs) throws SQLException{
        return new Cart(rs.getInt("orderId"), rs.getInt("customerID"),
                rs.getInt("artworkID"), rs.getString("dateCreate"), rs.getString("artworkTitle"));
    }
}
