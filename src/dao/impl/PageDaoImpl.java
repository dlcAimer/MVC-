package dao.impl;

import dao.PageDao;
import entity.Artwork;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29252 on 2017/7/26.
 */
public class PageDaoImpl implements PageDao{
    private JdbcUtil util;

    public PageDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public List<Artwork> getByPage(int page, int pageSize) {
        Connection conn = util.getConnection ();
        int start = (page - 1) * pageSize;
        PageDao pageDao = new PageDaoImpl ();
        //边界处理
        if( start > pageDao.total () || start <= 0){
            start = 1;
        }
        //language=MySQL
        String sql = "SELECT * FROM art.artwork WHERE sell = 0 ORDER BY ArtWorkID DESC LIMIT ?,?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artwork> artworks = new ArrayList<>();
        try{
            pst = conn.prepareStatement (sql);
            pst.setInt (1,start);
            pst.setInt (2,pageSize);
            rs = pst.executeQuery ();
            while(rs.next ()){
                artworks.add(buildArtwork (rs));
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        }finally {
            util.close (rs,pst,conn);
        }
        return artworks;
    }

    @Override
    public int total() {
        Connection conn = util.getConnection ();
        int num = 0;
        //language=MySQL
        String sql = "SELECT  COUNT(*) FROM art.artwork WHERE sell = 0 ";
        PreparedStatement pst = null;
        ResultSet rs = null;
        try {
            pst = conn.prepareStatement (sql);
            rs = pst.executeQuery ();
            if(rs.next ()){
                num = rs.getInt("COUNT(*)");
            }
        } catch (SQLException e) {
            e.printStackTrace ();
        } finally {
            util.close (null,pst,conn);
        }
        return num;
    }

    private Artwork buildArtwork(ResultSet rs) throws SQLException{
        return new Artwork(rs.getInt("artWorkId"), rs.getInt("artistId"), rs.getString("imageFileName"),
                rs.getString("title"), rs.getString("description"), rs.getString("excerpt"),
                rs.getInt("artWorkType"), rs.getInt("yearOfWork"), rs.getInt("width"),
                rs.getInt("height"), rs.getString("medium"), rs.getString("originalHome"),
                rs.getInt("galleryId"), rs.getBigDecimal("cost"), rs.getBigDecimal("msrp"),
                rs.getString("artWorkLink"), rs.getString("googleLink"), rs.getInt("sell"),
                rs.getInt("heat"));
    }
}
