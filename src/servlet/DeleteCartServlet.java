package servlet;

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
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "DeleteCartServlet",value = "/deleteCart")
public class DeleteCartServlet extends HttpServlet {
    private SellService sellService = new SellServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cartId = Integer.parseInt(request.getParameter("id"));
        sellService.deleteCart(cartId);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/cart");
        dispatcher.forward(request,response);
    }
}
