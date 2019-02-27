package service.impl;

import dao.DaoFactory;
import dao.PageDao;
import dao.impl.PageDaoImpl;
import entity.Artwork;
import service.PageService;

import java.util.List;

/**
 * Created by 29252 on 2017/7/26.
 */
public class PageServiceImpl implements PageService{
    private PageDao pageDao= DaoFactory.getPageDaoImpl();

    @Override
    public List<Artwork> getByPage(int page, int pageSize) {
        return pageDao.getByPage(page,pageSize);
    }

    @Override
    public int totalPage(int Pagesize) {
        int totalPage=pageDao.total()/Pagesize;
        int remain=pageDao.total()%Pagesize;
        return remain==0 ? totalPage:totalPage+1;
    }
}
