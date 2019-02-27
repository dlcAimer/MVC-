package dao.impl;

import entity.Onesorder;
import dao.OnesorderDao;
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
public class OnesorderDaoImpl implements OnesorderDao{
    private JdbcUtil util;

    public OnesorderDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public Onesorder getOne(int onesorderId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.onesorder WHERE OnesorderID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Onesorder onesordero = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,onesorderId);
            rs =  pst.executeQuery();
            if (rs.next()) {
                onesordero = buildOnesorder(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return onesordero;
    }

    @Override
    public List<Onesorder> getAll(int customerId) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.onesorder WHERE CustomerID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Onesorder> onesorders = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, customerId);
            rs =  pst.executeQuery();
            while (rs.next()) {
                onesorders.add(buildOnesorder(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return onesorders;
    }

    @Override
    public Onesorder add(Onesorder onesorder) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "INSERT INTO art.onesorder (OnesorderID, CustomerID, ArtworkID, ArtWorkTitle,DateCreate, DateCompleted)" +
                " VALUES (?,?,?,?,?,?)"; // 11
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, onesorder.getOnesorderId());
            pst.setInt(2, onesorder.getCustomerId());
            pst.setInt(3, onesorder.getArtWorkId());
            pst.setString(4, onesorder.getArtWorkTitle());
            pst.setString(5, onesorder.getDateCreate());
            pst.setString(6, onesorder.getDateCompleted());
            pst.executeUpdate();
            flag = true;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(null, pst, conn);
        }
        return flag ? onesorder : null;
    }

    @Override
    public void delete(int onesorderId) {
        Connection conn = util.getConnection();
        //language=MySQL
        if (getOne(onesorderId) != null) {

            String sql = "DELETE FROM art.onesorder WHERE OnesorderID = ?";
            PreparedStatement pst = null;
            try {
                pst = conn.prepareStatement(sql);
                pst.setInt(1, onesorderId);
                pst.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                util.close(null, pst, conn);
            }
        }
    }

    private Onesorder buildOnesorder(ResultSet rs) throws SQLException {
        return new Onesorder(rs.getInt("OnesorderId"), rs.getInt("customerId"),
                rs.getInt("artworkId"), rs.getString("artworkTitle"),
                rs.getString("dateCreate"), rs.getString("dateCompleted"));
    }
}
