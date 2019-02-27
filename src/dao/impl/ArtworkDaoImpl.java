package dao.impl;

import dao.ArtworkDao;
import entity.Artwork;
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
public class ArtworkDaoImpl implements ArtworkDao{
    private JdbcUtil util;

    public ArtworkDaoImpl() {
        this.util = new JdbcUtil();
    }

    @Override
    public Artwork getOne(int artworkId) {
        Connection conn = util.getConnection();
        String sql = "SELECT\n" + " art.artwork.*,\n" + " group_concat(DISTINCT subject.SubjectName SEPARATOR ',') AS subjects\n" +
                "FROM art.artwork\n" + " INNER JOIN art.artworksubjects ON art.artwork.ArtWorkID = art.artworksubjects.ArtWorkID\n" +
                "  INNER JOIN art.subject ON art.subject.SubjectId = art.artworksubjects.SubjectID\n" +
                "WHERE art.artwork.ArtWorkID = ?\n" + "GROUP BY artwork.ArtWorkID";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Artwork artwork = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,artworkId);
            rs = pst.executeQuery();
            if (rs.next()) {
                artwork = buildArtwork_2(rs);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs, pst, conn);
        }
        return artwork;
    }

    @Override
    public Artwork sell(Artwork artwork) {
        Connection conn = util.getConnection();
        //sell
        String sql = "UPDATE art.artwork SET sell = ? WHERE artWorkId = ?";
        PreparedStatement pst = null;
        boolean flag = false;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, artwork.getSell());
            pst.setInt(2, artwork.getArtWorkId());
            pst.executeUpdate();
            flag = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? artwork : null;
    }

    @Override
    public boolean ifsell(Artwork artwork) {
        return artwork.getSell() == 1;
    }

    @Override
    public int getHeat(Artwork artwork) {
        return artwork.getHeat();
    }

    @Override
    public Artwork updateHeat(Artwork artwork) {
        Connection conn = util.getConnection();
        //sell
        String sql = "UPDATE art.artwork SET heat = ? WHERE artWorkId = ?";
        PreparedStatement pst = null;
        boolean flag = false;

        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1, artwork.getHeat());
            pst.setInt(2, artwork.getArtWorkId());
            pst.executeUpdate();
            flag = true;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(null, pst, conn);
        }
        return flag ? artwork : null;
    }

    @Override
    public List<Artwork> getAll() {
        Connection conn = util.getConnection();
        String sql = "SELECT\n" + "  art.artwork.*,\n" +
                "  group_concat(DISTINCT art.subject.SubjectName SEPARATOR ',') AS subjects\n" +
                "FROM art.artwork\n" + "  INNER JOIN art.artworksubjects ON art.artwork.ArtWorkID = art.artworksubjects.ArtWorkID\n" +
                "  INNER JOIN art.subject ON art.subject.SubjectId = art.artworksubjects.SubjectID\n" +
                "GROUP BY artwork.ArtWorkID";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artwork> artworks = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                artworks.add(buildArtwork_2(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs,pst,conn);
        }
        return artworks;
    }

    @Override
    public List<Artwork> getHottest() {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM art.artwork WHERE sell = 0 ORDER BY heat DESC";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artwork> artworks = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            for (int i = 0;i < 3;i++) {
                rs.next();
                artworks.add(buildArtwork(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs,pst,conn);
        }
        return artworks;
    }

    @Override
    public List<Artwork> getNewest() {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM art.artwork WHERE sell = 0 ORDER BY ArtWorkID DESC";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artwork> artworks = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            for (int i = 0;i < 3;i++) {
                rs.next();
                artworks.add(buildArtwork(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs,pst,conn);
        }
        return artworks;
    }

    @Override
    public List<Artwork> getAllArtworkByArtistId(int artistId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM art.artwork WHERE ArtistID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artwork> artworks = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,artistId);
            rs = pst.executeQuery();
            while (rs.next()) {
                artworks.add(buildArtwork(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs,pst,conn);
        }
        return artworks;
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

    private Artwork buildArtwork_2(ResultSet rs) throws SQLException{
        return new Artwork(rs.getInt("artWorkId"), rs.getInt("artistId"), rs.getString("imageFileName"),
                rs.getString("title"), rs.getString("description"), rs.getString("excerpt"),
                rs.getInt("artWorkType"), rs.getInt("yearOfWork"), rs.getInt("width"),
                rs.getInt("height"), rs.getString("medium"), rs.getString("originalHome"),
                rs.getInt("galleryId"), rs.getBigDecimal("cost"), rs.getBigDecimal("msrp"),
                rs.getString("artWorkLink"), rs.getString("googleLink"), rs.getInt("sell"),
                rs.getInt("heat"), rs.getString("subjects"));
    }
}
