package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Movie;
import ru.itis.repositories.MovieRepository;
import ru.itis.repositories.MovieRepositoryJbdcImpl;
import ru.itis.services.SearchService;
import ru.itis.services.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/search")
public class SearchServlet extends HttpServlet {
    private SearchService searchService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cinematest");
        MovieRepository repository = new MovieRepositoryJbdcImpl(dataSource);
        this.searchService = new SearchServiceImpl(repository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setCharacterEncoding("UTF-8");
        String query = req.getParameter("q");
        if (query !=null){
            List<Movie> result = searchService.searchByTitle(query);
            String resultJson = mapper.writeValueAsString(result);
            resp.setStatus(200);
            resp.setContentType("application/json");
            PrintWriter writer = resp.getWriter();
            writer.write(resultJson);
        } else {
            req.getRequestDispatcher("search.jsp").forward(req, resp);
        }
    }
}
