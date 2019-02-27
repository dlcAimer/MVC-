package service;

import entity.Artwork;

import java.util.List;

/**
 * Created by 29252 on 2017/7/26.
 */
public interface PageService {
//    得到一页上的艺术品信息
    List<Artwork> getByPage(int page, int pageSize);

//    得到所有的页面
    int totalPage(int pageSize);
}
