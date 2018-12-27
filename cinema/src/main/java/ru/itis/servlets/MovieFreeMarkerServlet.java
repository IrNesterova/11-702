package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.forms.movieForm;
import ru.itis.models.Movie;
import ru.itis.repositories.MovieRepository;
import ru.itis.repositories.MovieRepositoryJbdcImpl;
import ru.itis.services.MovieService;
import ru.itis.services.MovieServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URL;
import java.util.List;

@WebServlet(name = "movieList", urlPatterns = {"/movieList"})
public class MovieFreeMarkerServlet extends HttpServlet {
    private static final String ADD_USER_VIEW = "ftl/addMovie.ftl";
    private static final String UPDATE_USER_VIEW = "ftl/updateMovie.ftl";
    private static final String LIST_USERS_VIEW = "ftl/movieList.ftl";

    private MovieService movieService;
    private MovieRepository movieRepository;
    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cinematest");
        MovieRepository productRepository = new MovieRepositoryJbdcImpl(dataSource);
        this.movieService = new MovieServiceImpl(productRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Movie> movieList = movieService.getMovie();

        req.setAttribute("movieList", movieList);

        String action = req.getParameter("action");
        String DELETE_ACTION = "deleteMovie";
        String ADD_ACTION = "addMovie";
        String EDIT_ACTION = "editMovie";
        String path = "";
        if (DELETE_ACTION.equals(action)){
            Long id_movie = Long.parseLong(req.getParameter("id_movie"));
            movieService.deleteMovie(id_movie);
        } else if (EDIT_ACTION.equals(action)){
            Long movieId = Long.parseLong(req.getParameter("id_movie"));
            Movie movie = movieService.getMovieById(movieId);
            req.setAttribute("movieList", movie);
            path = UPDATE_USER_VIEW;
        } else if (ADD_ACTION.equals(action)){
            path = ADD_USER_VIEW;
        } else {
            path = "/ftl/movieList.ftl";
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String ADD_ACTION = "addMovie";
        String EDIT_ACTION = "editMovie";
        if (ADD_ACTION.equals(action)) {
            Long id_movie = Long.parseLong(req.getParameter("id_movie"));
            String title = req.getParameter("title");
            String director = req.getParameter("director");
            String actors = req.getParameter("actors");
            String description = req.getParameter("description");
            String duration_min = req.getParameter("duration_min");
            String ratings = req.getParameter("ratings");
            String posteraddress = req.getParameter("posteraddress");

            movieForm movieForm = ru.itis.forms.movieForm.builder()
                    .id_movie(id_movie)
                    .title(title)
                    .director(director)
                    .actors(actors)
                    .description(description)
                    .duration_min(duration_min)
                    .ratings(ratings)
                    .posteraddress(posteraddress)
                    .build();
            movieService.addMovie(movieForm);
            resp.sendRedirect("movieList");
        } else if (EDIT_ACTION.equals(action)) {
            Long movieId = Long.parseLong(req.getParameter("id"));
            Movie movie = movieService.getMovieById(movieId);
            movie.setTitle(req.getParameter("title"));
            movie.setDirector(req.getParameter("director"));
            movie.setActors(req.getParameter("actors"));
            movie.setDescription(req.getParameter("actors"));
            movie.setDuration_min(req.getParameter("duration"));
            movie.setRatings(req.getParameter("ratings"));
            movie.setPosterAddress(req.getParameter("posteraddress"));
            movieService.editMovie(movie);
            resp.sendRedirect("ftl/movieList.ftl");
        }
    }
}
