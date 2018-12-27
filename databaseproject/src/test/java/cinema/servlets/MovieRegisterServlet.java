package cinema.servlets;

import cinema.Forms.MovieForm;
import cinema.respositories.MovieRepository;
import cinema.respositories.MovieRepositoryJbdcImpl;
import cinema.services.MovieService;
import cinema.services.MovieServiceImpl;
import lombok.SneakyThrows;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@WebServlet("/Register")
public class MovieRegisterServlet extends HttpServlet {
    private MovieService movieService;

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\admin.WIN-IPM3OA3VQNQ\\Desktop\\Java\\11-702\\WebTaxiService\\src\\main\\resources\\ru.itis\\application.properties"));
        Connection connection =
                DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"),
                        properties.getProperty("db.password"));
        MovieRepository movieRepository = new MovieRepositoryJbdcImpl(connection);
        movieService = new MovieServiceImpl(movieRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("src/webapp/jsp/Register.jsp")
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MovieForm movieForm = MovieForm.builder()
                .title(req.getParameter("title"))
                .actors(req.getParameter("actors"))
                .description(req.getParameter("description"))
                .director(req.getParameter("director"))
                .duration_min(req.getParameter("duration_min"))
                .build();
        movieService.Register(movieForm);
        resp.sendRedirect("/Register");
    }
}
