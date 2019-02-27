package dao;

import entity.Artwork;

import java.util.List;

/**
 * Created by 29252 on 2017/7/21.
 */
public interface ArtworkDao {
//    得到所有的艺术品
    List<Artwork> getAll();

//    得到某个艺术品
    Artwork getOne(int artworkId);

//    卖出某个艺术品
    Artwork sell(Artwork artwork);

//    判断某个艺术品是否卖出
    boolean ifsell(Artwork artwork);

//    得到某个艺术品的热度
    int getHeat(Artwork artwork);

//    更新某个艺术品的热度
    Artwork updateHeat(Artwork artwork);

//    得到最热门的艺术品
    List<Artwork> getHottest();

//    得到最新的艺术品
    List<Artwork> getNewest();

//    得到某个艺术系家的所有艺术品
    List<Artwork> getAllArtworkByArtistId(int artistId);
}
