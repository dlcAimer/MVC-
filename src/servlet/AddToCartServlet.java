package servlet;

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

/**
 * 此为将艺术品添加至购物车的servlet
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "AddToCartServlet",value = "/addToCart")
public class AddToCartServlet extends HttpServlet {
    private SellService sellService = new SellServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customers customers = (Customers) request.getSession().getAttribute("user");
        if (customers == null || customers.getCustomerLogon().getUserName() == null) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("/login.jsp");
            requestDispatcher.forward(request, response);
        }
        else {
            int customerId = customers.getCustomerId();
            int artworkId = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            if(!sellService.ifin(artworkId,customerId)) {
                sellService.addCart(customerId, artworkId, title);
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cart");
                requestDispatcher.forward(request, response);
            }
            else {
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("/cart");
                requestDispatcher.forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
