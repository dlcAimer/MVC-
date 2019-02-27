package dao.impl;

import dao.ArtistDao;
import entity.Artist;
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
public class ArtistDaoImpl implements ArtistDao{
    private JdbcUtil util;

    public ArtistDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public Artist getOne(int artistId){
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM art.artist WHERE ArtistID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Artist artist = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,artistId);
            rs = pst.executeQuery();
            if (rs.next()) {
                artist = buildArtist(rs);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs, pst, conn);
        }

        return artist;
    }

    @Override
    public List<Artist> getAll() {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM art.artist";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Artist> artists = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                artists.add(buildArtist(rs));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs,pst,conn);
        }
        return artists;
    }

    private Artist buildArtist(ResultSet rs) throws SQLException{
        // artistId, firstName lastName nationality yearOfBirth yearOfDeath details artistLink
        return new Artist(rs.getInt("artistId"), rs.getString("firstName"), rs.getString("lastName"),
                rs.getString("nationality"), rs.getInt("yearOfBirth"), rs.getInt("yearOfDeath"),
                rs.getString("details"), rs.getString("artistLink"));
    }
}
