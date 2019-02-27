package servlet;

import entity.Cart;
import entity.Customers;
import service.SellService;
import service.impl.SellServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 这是用于购买艺术品的servlet
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "BuyServlet",value = "/buy")
public class BuyServlet extends HttpServlet {
    private SellService sellService = new SellServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customers customers = (Customers) request.getSession().getAttribute("user");
        int customerId = customers.getCustomerId();
        List<Cart> carts = sellService.getAll(customerId);
        for (Cart cart: carts) {
            int cartId = cart.getOrderId();
            if (request.getParameter(cartId+"") != null){
//                将要购买的艺术品从购物车添加至订单中
                sellService.addOrder(cart);
            }
        }
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cart");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
