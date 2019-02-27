package dao.impl;

import entity.Artist;
import entity.Artwork;
import dao.SearchDao;
import util.JdbcUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 29252 on 2017/7/25.
 */
public class SearchDaoImpl implements SearchDao{
    private JdbcUtil util;

    public SearchDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public List<Artwork> searchByTitle(String keyword, String sortBy) {
        Connection conn = util.getConnection ();
        //language=MySQL
        String sql = "SELECT * FROM art.artwork WHERE Title LIKE ? AND sell = 0 ORDER BY "+sortBy;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artwork> artworks = new ArrayList<>();
        try{
            pst = conn.prepareStatement (sql);
            pst.setString (1,"%"+keyword+"%");
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
    public List<Artwork> searchByDescription(String keyword, String sortBy) {
        Connection conn = util.getConnection ();
        //language=MySQL
        String sql = "SELECT * FROM art.artwork WHERE Description LIKE ? AND sell = 0 ORDER BY "+sortBy;
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artwork> artworks = new ArrayList<>();
        try{
            pst = conn.prepareStatement (sql);
            pst.setString (1,"%"+keyword+"%");
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
    public List<Artist> searchByArtist(String keyword) {
        Connection conn = util.getConnection();
        //language=MySQL
        String sql = "SELECT * FROM art.artist WHERE FirstName LIKE ? OR LastName LIKE ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artist> artists = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setString (1,"%"+keyword+"%");
            pst.setString (2,"%"+keyword+"%");
            rs =  pst.executeQuery();
            while (rs.next()) {
                artists.add(buildArtist(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            util.close(rs, pst, conn);
        }
        return artists;
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

    private Artist buildArtist(ResultSet rs) throws SQLException{
        // artistId, firstName lastName nationality yearOfBirth yearOfDeath details artistLink
        return new Artist(rs.getInt("artistId"), rs.getString("firstName"), rs.getString("lastName"),
                rs.getString("nationality"), rs.getInt("yearOfBirth"), rs.getInt("yearOfDeath"),
                rs.getString("details"), rs.getString("artistLink"));
    }
}
