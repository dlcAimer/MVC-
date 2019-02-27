package servlet;

import service.CustomerService;
import service.impl.CustomerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value = "/login", name = "login")
public class LoginServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        if (customerService.existed(username)) {
            if (customerService.login(username,password) != null) {
                request.getSession().setAttribute("user", customerService.login(username,password));
                response.getWriter().print("{\"existed\": \"TRUE\",\"password\": \"TRUE\"}");
            }
            else {
                response.getWriter().print("{\"existed\": \"TRUE\",\"password\": \"FALSE\"}");
            }
        }
        else {
            response.getWriter().print("{\"existed\": \"FALSE\"}");
        }
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }
}
