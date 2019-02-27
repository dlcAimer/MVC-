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
 * Created by 29252 on 2017/7/24.
 */
@WebServlet(name = "ShowArtistServlet",value = "/showArtist")
public class ShowArtistServlet extends HttpServlet {
    private ArtworkService artworkService = new ArtworkServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int artistId = Integer.parseInt(request.getParameter("artistId"));
        request.setAttribute("artist", artworkService.getOneArtist(artistId));
        request.setAttribute("works", artworkService.getAllArtworkByArtistId(artistId));
        RequestDispatcher dispatcher = request.getRequestDispatcher("artists.jsp");
        dispatcher.forward(request,response);
    }
}
