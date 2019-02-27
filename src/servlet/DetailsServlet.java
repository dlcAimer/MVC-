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
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "DetailsServlet",value = "/details")
public class DetailsServlet extends HttpServlet {
    private ArtworkService artworkService = new ArtworkServiceImpl();

    private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int artworkId = Integer.parseInt(request.getParameter("artworkId"));
        artworkService.updateHeat(artworkService.getOne(artworkId));
        request.setAttribute("artwork", artworkService.getOne(artworkId));
        request.setAttribute("artist", artworkService.getOneArtistByArtworkId(artworkId));
        request.setAttribute("genres", artworkService.getGenres(artworkId));
        request.setAttribute("work",artworkService.getAllArtworkByArtistId(artworkId));
        RequestDispatcher dispatcher = request.getRequestDispatcher("details.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doRequest(request, response);
    }
}
