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
 * 此为通过艺术家ID得到艺术家信息的servlet
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "ArtistServlet",value = "/artist")
public class ArtistServlet extends HttpServlet {
    private ArtworkService artworkService = new ArtworkServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int artistId = Integer.parseInt(request.getParameter("artistId"));
        request.setAttribute("artist", artworkService.getOneArtist(artistId));
        request.setAttribute("works", artworkService.getAllArtworkByArtistId(artistId));
        RequestDispatcher dispatcher = request.getRequestDispatcher("artist.jsp");
        dispatcher.forward(request,response);
    }
}
