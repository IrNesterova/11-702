package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.forms.screeningForm;
import ru.itis.models.Auditorium;
import ru.itis.models.Screening;
import ru.itis.repositories.*;
import ru.itis.services.ScreeningService;
import ru.itis.services.ScreeningServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@WebServlet(name = "screening", urlPatterns = {"/screening"})
public class ScreeningFreemarkerServlet extends HttpServlet {
    private static final String ADD_USER_VIEW = "ftl/addScreening.ftl";
    private static final String UPDATE_USER_VIEW = "ftl/updateScreening.ftl";
    private static final String LIST_USERS_VIEW = "ftl/screeningList.ftl";

    private ScreeningService screeningService;
    private MovieRepository movieRepository;
    private AuditoriumRepository auditoriumRepository;
    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cinematest");
        movieRepository = new MovieRepositoryJbdcImpl(dataSource);
        auditoriumRepository = new AuditoriumRepositoryJdbcImpl(dataSource);
        ScreeningRepository screeningRepository = new ScreeningRepositoryJbdcImpl(dataSource, movieRepository,auditoriumRepository);
        this.screeningService = new ScreeningServiceImpl(screeningRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Screening> screeningList = screeningService.getScreening();
        req.setAttribute("screeningList", screeningList);

        String action = req.getParameter("action");
        String DELETE_ACTION = "deleteScreening";
        String ADD_ACTION = "addScreening";
        String EDIT_ACTION = "editScreening";
        String OPEN_RESERVATION = "reserveSeat";
        String path = "";
        if (DELETE_ACTION.equals(action)){
            Long id = Long.parseLong(req.getParameter("id_screening"));
            screeningService.deleteScreening(id);
        } else if (EDIT_ACTION.equals(action)){
            Long id = Long.parseLong(req.getParameter("id_screening"));
            Screening screening = screeningService.getScreeningById(id);
            req.setAttribute("screeningList", screening);
            path = UPDATE_USER_VIEW;
        } else if (ADD_ACTION.equals(action)){
            path = ADD_USER_VIEW;
        } else if (OPEN_RESERVATION.equals(action)){
            path = "";
        } else {
            path = "/ftl/screening.ftl";
        }
        req.getRequestDispatcher(path).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String ADD_ACTION = "addScreening";
        String EDIT_ACTION = "editScreening";
        if (ADD_ACTION.equals(action)) {
            Long id_screening = Long.parseLong(req.getParameter("id_screening"));
            Long movie_id = Long.parseLong(req.getParameter("id_movie"));

            Long auditorium_id = Long.parseLong(req.getParameter("auditorium_id"));
            Timestamp screeningStart = Timestamp.valueOf(req.getParameter("screening_start"));
            screeningForm screeningForm = ru.itis.forms.screeningForm.builder()
                    .id_screening(id_screening)
                    .auditorium_id(auditorium_id)
                    .id_movie(movie_id)
                    .screening_start(screeningStart)
                    .build();
            screeningService.addScreening(screeningForm);
            resp.sendRedirect("screening");
        } else if (EDIT_ACTION.equals(action)) {

            Long movieId = Long.parseLong(req.getParameter("id_screening"));
            Screening screening = screeningService.getScreeningById(movieId);
            screening.setAuditorium_id(req.getParameter("auditorium_id"));
            screening.setId_movie(req.getParameter("id_movie"));
            screening.setScreening_start(Timestamp.valueOf(req.getParameter("screening_start")));
            screeningService.editScreening(screening);
            resp.sendRedirect("screening");
        }

    }
}
