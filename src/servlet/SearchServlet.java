package servlet;

import entity.Artwork;
import service.SearchService;
import service.impl.SearchServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by 29252 on 2017/7/26.
 */
@WebServlet(name = "SearchServlet",value = "/search")
public class SearchServlet extends HttpServlet {
    private SearchService searchService=new SearchServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String keyword = (String) request.getParameter("keyword");
        String method = (String) request.getParameter("searchBy");
        String sortBy = (String) request.getParameter("sortBy");
        List<Artwork> artworks = null;
        switch (method) {
            case "Title":
                artworks = searchService.searchByTitle(keyword, sortBy);
                break;
            case "Description":
                artworks = searchService.searchByDescription(keyword, sortBy);
                break;
            default:
                artworks = searchService.searchByArtist(keyword, sortBy);
                break;
        }
        request.setAttribute("artworks", artworks);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("./search.jsp");
        requestDispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
