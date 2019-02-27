package dao;

import entity.Artist;
import java.util.List;
/**
 * Created by 29252 on 2017/7/21.
 */
public interface ArtistDao {
//    得到所有的艺术家
    List<Artist> getAll();

//    得到某一个艺术家
    Artist getOne(int artistId);
}
