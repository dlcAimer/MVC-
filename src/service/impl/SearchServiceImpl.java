package service.impl;

import dao.ArtworkDao;
import dao.DaoFactory;
import dao.SearchDao;
import entity.Artist;
import entity.Artwork;
import service.SearchService;
import util.Compare1Util;
import util.Compare2Util;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Created by 29252 on 2017/7/26.
 */
public class SearchServiceImpl implements SearchService{
    private SearchDao searchDao= DaoFactory.getSearchDaoImpl();
    private ArtworkDao artworkDao=DaoFactory.getArtworkDaoInstance();
    private Comparator<Artwork> comparator1=new Compare1Util();
    private Comparator<Artwork> comparator2=new Compare2Util();

    @Override
    public List<Artwork> searchByTitle(String keyword, String sortBy) {
        return searchDao.searchByTitle(keyword,sortBy);
    }

    @Override
    public List<Artwork> searchByDescription(String keyword, String sortBy) {
        return searchDao.searchByDescription(keyword,sortBy);
    }

    @Override
    public List<Artwork> searchByArtist(String keyword,String sortBy) {
        List<Artist> artists=searchDao.searchByArtist(keyword);
        List<Artwork> artworks=new ArrayList<>();
        for (Artist artist : artists) {
            artworks.addAll(artworkDao.getAllArtworkByArtistId(artist.getArtistId()));
        }
        if (sortBy.equals("Cost")){
            artworks.sort(comparator1);
        }
        else if(sortBy.equals("Date"))
            artworks.sort(comparator2);
        return artworks;
    }
}
