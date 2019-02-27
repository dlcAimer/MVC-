package service.impl;

import service.SellService;
import dao.ArtworkDao;
import dao.DaoFactory;
import dao.CartDao;
import dao.OnesorderDao;
import entity.Artwork;
import entity.Onesorder;
import entity.Cart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
/**
 * Created by 29252 on 2017/7/21.
 */
public class SellServiceImpl implements SellService{
    private CartDao cartDao;
    private OnesorderDao onesorderDao;
    private ArtworkDao artworkDao;

    public SellServiceImpl() {
        onesorderDao = DaoFactory.getOnesorderDaoImpl();
        cartDao = DaoFactory.getCartDaoImpl();
        artworkDao =DaoFactory.getArtworkDaoInstance();
    }

    @Override
    public Cart addCart(int customerId, int artworkId, String artworkTitle) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String time = df.format(new Date());
        Cart cart = new Cart(customerId,artworkId,time,artworkTitle);
        if (cartDao.ifin(artworkId, customerId))
            return null;
        else  {
            cartDao.add(cart);
            return cart;
        }
    }

    @Override
    public void deleteCart(int cartId) {
        cartDao.delete(cartId);
    }

    @Override
    public List<Cart> getAll(int customerId) {
        return cartDao.getAll(customerId);
    }

    @Override
    public Onesorder addOrder(Cart cart) {
        int customerId = cart.getCustomerId();
        int artworkId = cart.getArtworkId();
        String title = cart.getArtworkTitle();
        String dateCreate = cart.getDateCreate();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateCompleted = df.format(new Date());
        Onesorder onesorder = onesorderDao.add(new Onesorder(customerId, artworkId, title, dateCreate, dateCompleted));
        Artwork artwork = artworkDao.getOne(artworkId);
        artwork.setSell(1);
        artworkDao.sell(artwork);
        List<Cart> cartsToDelete = cartDao.getAllByArtworkId(artworkId);
        for (Cart c: cartsToDelete) {
            cartDao.delete(c.getOrderId());
        }
        return onesorder;
    }

    @Override
    public List<Onesorder> getAllOrders(int customerId) {
        return onesorderDao.getAll(customerId);
    }

    @Override
    public boolean ifin(int artworkId,int customerId){
        return cartDao.ifin(artworkId,customerId);
    }
}
