package dao.impl;

import dao.GenreDao;
import entity.Artworkgenres;
import entity.Genre;
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
public class GenreDaoImpl implements GenreDao{
    private JdbcUtil util;
    public GenreDaoImpl() {
        util = new JdbcUtil();
    }

    @Override
    public String getGenres(int artworkId) {
        List<Integer> genreIds = getGenreIds(artworkId);
        String s = "";
        for (int i = 0;i < genreIds.size();i++) {
            s += getOne(genreIds.get(i)).getGenreName();
            if (i < genreIds.size() - 1)
                s += ",";
        }
        return s;
    }

    @Override
    public Genre getOne(int genreId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM art.genre WHERE GenreID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        Genre genre = null;
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,genreId);
            rs = pst.executeQuery();
            if (rs.next()) {
                genre = buildGenre(rs);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs, pst, conn);
        }
        return genre;
    }

    private List<Integer> getGenreIds(int artworkId) {
        Connection conn = util.getConnection();
        String sql = "SELECT * FROM art.artworkgenres WHERE ArtWorkID = ?";
        PreparedStatement pst = null;
        ResultSet rs = null;
        List<Integer> genreIds = new ArrayList<>();
        try {
            pst = conn.prepareStatement(sql);
            pst.setInt(1,artworkId);
            rs = pst.executeQuery();
            if (rs.next()) {
                genreIds.add(buildArtworkGenres(rs).getGenreId());
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            util.close(rs, pst, conn);
        }
        return genreIds;
    }

    private Artworkgenres buildArtworkGenres(ResultSet rs) throws SQLException{
        return new Artworkgenres(rs.getInt("artWorkGenreId"), rs.getInt("artWorkId"),
                rs.getInt("genreId"));
    }

    private Genre buildGenre(ResultSet rs) throws SQLException {
        return new Genre(rs.getInt("genreId"), rs.getString("genreName"),
                rs.getInt("era"), rs.getString("description"),
                rs.getString("link"));
    }
}
