package dao;

import entity.Genre;

/**
 * Created by 29252 on 2017/7/21.
 */
public interface GenreDao {
    String getGenres(int artworkId);
    Genre getOne(int genreId);
}
