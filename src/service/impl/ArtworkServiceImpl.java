package service.impl;

import service.ArtworkService;
import dao.ArtistDao;
import dao.ArtworkDao;
import dao.DaoFactory;
import dao.GenreDao;
import entity.Artist;
import entity.Artwork;

import java.util.List;
/**
 * Created by 29252 on 2017/7/21.
 */
public class ArtworkServiceImpl implements ArtworkService{
    private ArtworkDao artworkDao;
    private ArtistDao artistDao;
    private GenreDao genreDao;

    public ArtworkServiceImpl() {
        artistDao = DaoFactory.getArtistDaoImpl();
        artworkDao = DaoFactory.getArtworkDaoInstance();
        genreDao = DaoFactory.getGenreDaoImpl();
    }

    @Override
    public Artwork getOne(int artworkId) {
        return artworkDao.getOne(artworkId);
    }

    @Override
    public Artwork sell(Artwork artwork) {
        artwork.setSell(1);
        return artworkDao.sell(artwork);
    }

    @Override
    public boolean ifsell(Artwork artwork) {
        return artworkDao.ifsell(artwork);
    }

    @Override
    public int getHeat(Artwork artwork) {
        return artworkDao.getHeat(artwork);
    }

    @Override
    public Artwork updateHeat(Artwork artwork) {
        artwork.setHeat(artwork.getHeat() + 1);
        return artworkDao.updateHeat(artwork);
    }

    @Override
    public List<Artwork> getHottest() {
        return artworkDao.getHottest();
    }

    @Override
    public List<Artwork> getNewest() {
        return artworkDao.getNewest();
    }

    @Override
    public List<Artwork> getAll() {
        return artworkDao.getAll();
    }

    @Override
    public String getGenres(int artworkId) {
        return genreDao.getGenres(artworkId);
    }

    @Override
    public List<String> getSubjects(int artworkId) {
        return null;
    }

    @Override
    public List<Artwork> getAllArtworkByArtistId(int artistId) {
        return artworkDao.getAllArtworkByArtistId(artistId);
    }

    @Override
    public Artist getOneArtistByArtworkId(int artworkId) {
        return artistDao.getOne(getOne(artworkId).getArtistId());
    }

    @Override
    public Artist getOneArtist(int artistId) {
        return artistDao.getOne(artistId);
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistDao.getAll();
    }

}
