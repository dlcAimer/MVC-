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
 * 这是用于购物车显示的servlet
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "CartServlet",value = "/cart")
public class CartServlet extends HttpServlet {
    private SellService sellService = new SellServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customers customers = (Customers) request.getSession().getAttribute("user");
        if (customers == null || customers.getCustomerLogon().getUserName() == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            int customerId = customers.getCustomerId();
            List<Cart> carts = sellService.getAll(customerId);
            request.setAttribute("carts", carts);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("./cart.jsp");
            requestDispatcher.forward(request, response);
        }
    }
}
