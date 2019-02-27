package dao;

import dao.impl.*;

/**
 * Created by 29252 on 2017/7/20.
 */
public class DaoFactory {

    public static CustomerDao getCustomerDaoInstance() {

        return new CustomerDaoImpl();
    }

    public static CustomerLogonDao getCustomerLogonDaoInstance() {

        return new CustomerLogonDaoImpl();
    }

    public static CartDao getCartDaoInstance() {

        return new CartDaoImpl();
    }

    public static OnesorderDao getOnesorderDaoInstance(){

        return new OnesorderDaoImpl();
    }

    public static ArtworkDao getArtworkDaoInstance() {
        return new ArtworkDaoImpl();
    }

    public static ArtistDao getArtistDaoImpl() {
        return new ArtistDaoImpl();
    }

    public static GenreDao getGenreDaoImpl() { return new GenreDaoImpl();}

    public static CartDao getCartDaoImpl() { return new CartDaoImpl();}

    public static OnesorderDao getOnesorderDaoImpl() {return new OnesorderDaoImpl(); }

    public static PageDao getPageDaoImpl()  {return new PageDaoImpl();}

    public static SearchDao getSearchDaoImpl()  {return new SearchDaoImpl();}
}

