package servlet;

import entity.Customers;
import service.CustomerService;
import service.impl.CustomerServiceImpl;

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
@WebServlet(name = "SetServlet",value = "/set")
public class SetServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Customers customers = (Customers) request.getSession().getAttribute("user");

        String firstname = request.getParameter("firstname");
        String lastname = request.getParameter("lastname");
        String address = request.getParameter("address");
        String city = request.getParameter("city");
        String country = request.getParameter("country");
        String postal = request.getParameter("postal");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");

        customers.setFirstName(firstname);
        customers.setLastName(lastname);
        customers.setAddress(address);
        customers.setCity(city);
        customers.setCountry(country);
        customers.setPostal(postal);
        customers.setPhone(phone);
        customers.setEmail(email);
        customerService.update(customers);

        RequestDispatcher dispatcher = request.getRequestDispatcher("profile.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
