package dao;

import entity.Artwork;
import java.util.List;

/**
 *
 * Created by 29252 on 2017/7/26.
 */
public interface PageDao {
//    拿到一页上的作品
    List<Artwork> getByPage(int page, int pageSize);

//    未卖出的作品总数
    int total();
}
