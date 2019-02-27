package servlet;

import entity.Artist;
import entity.Artwork;
import service.ArtworkService;
import service.impl.ArtworkServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 此为得到所有艺术家信息的servlet
 * Created by 29252 on 2017/7/21.
 */
@WebServlet(name = "ArtistsServlet",value = "/artists")
public class ArtistsServlet extends HttpServlet {
    private ArtworkService artworkService = new ArtworkServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Artist> artists =artworkService.getAllArtists();
        List<List<Artwork>> works = new ArrayList<>();

        for (Artist aritist: artists) {
            works.add(artworkService.getAllArtworkByArtistId(aritist.getArtistId()));
        }

        request.setAttribute("works", works);

        request.setAttribute("artists", artists);
        RequestDispatcher dispatcher = request.getRequestDispatcher("artists.jsp");
        dispatcher.forward(request,response);
    }
}
