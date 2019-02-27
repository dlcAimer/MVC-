package dao;

import entity.Artist;
import entity.Artwork;

import java.util.List;

/**
 * Created by 29252 on 2017/7/25.
 */
public interface SearchDao {
//    通过标题搜索 按“sortby”排序
    List<Artwork> searchByTitle(String keyword,String sortBy);

//    通过描述搜索 按“sortby”排序
    List<Artwork> searchByDescription(String keyword,String sortBy);

//    通过作者名搜索 按“sortby”排序
    List<Artist> searchByArtist(String keyword);
}
