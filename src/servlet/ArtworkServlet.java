package servlet;

import service.ArtworkService;
import service.impl.ArtworkServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 这是用于返回不同属性 即所有、最热门或最新艺术品的servlet
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "ArtworkServlet", value = "/index")
public class ArtworkServlet extends HttpServlet {
    private ArtworkService artworkService = new ArtworkServiceImpl();

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("all", artworkService.getAll());
        request.setAttribute("heat", artworkService.getHottest());
        request.setAttribute("fresh", artworkService.getNewest());
        request.setAttribute("flag", "OK");
        RequestDispatcher dispatcher = request.getRequestDispatcher("./artworks.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }
}
