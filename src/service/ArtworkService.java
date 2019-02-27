package service;

import entity.Artist;
import entity.Artwork;

import java.util.List;

/**
 * Created by asus1 on 2017/7/17.
 */
public interface ArtworkService {
//    得到一个艺术品
    Artwork getOne(int artworkId);

//    卖出一个艺术品
    Artwork sell(Artwork artwork);

//    判断艺术品是否卖出
    boolean ifsell(Artwork artwork);

//    得到一个艺术品的热度
    int getHeat(Artwork artwork);

//    更新一个艺术品的热度
    Artwork updateHeat(Artwork artwork);

//    得到所有艺术品
    List<Artwork> getAll();

//    通过艺术家的序号得到他所有的艺术品
    List<Artwork> getAllArtworkByArtistId(int artistId);

//    得到最热门的艺术品
    List<Artwork> getHottest();

//    得到最新得艺术品
    List<Artwork> getNewest();

//    得到所有的艺术家
    List<Artist> getAllArtists();

//    通过一个艺术品的序号得到其对应的艺术家
    Artist getOneArtistByArtworkId(int artworkId);

//    得到一个艺术家信息
    Artist getOneArtist(int artistId);

//
    String getGenres(int artworkId);

//
    List<String> getSubjects(int artworkId);
}
