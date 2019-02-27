package servlet;

import entity.Customers;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();
    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Customers customers = customerService.register(email, username, password);
        if (customers != null) {
            request.getSession().setAttribute("user", customers);
            response.getWriter().print("{\"result\": \"OK\"}");
        }
        else {
            response.getWriter().print("{\"result\": \"ERROR\", \"error\": \"userName is already existed.\"}");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }
}
