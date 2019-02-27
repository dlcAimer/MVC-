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
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "RecordServlet",value = "/records")
public class RecordServlet extends HttpServlet {
    private SellService sellService = new SellServiceImpl();
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Customers customers = (Customers) request.getSession().getAttribute("user");
        request.setAttribute("orders", sellService.getAllOrders(customers.getCustomerId()));
        RequestDispatcher dispatcher = request.getRequestDispatcher("records.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
