package service;

import entity.Artist;
import entity.Artwork;

import java.util.List;

/**
 * Created by 29252 on 2017/7/26.
 */
public interface SearchService {
//    按照标题搜索 并按照"sortby"排序
    List<Artwork> searchByTitle(String keyword, String sortBy);

//    按照描述搜索 并按照"sortby"排序
    List<Artwork> searchByDescription(String keyword,String sortBy);

//    按照艺术家名搜索 并按照"sortby"排序
    List<Artwork> searchByArtist(String keyword,String sortBy);
}
