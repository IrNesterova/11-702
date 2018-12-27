package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.forms.movieForm;
import ru.itis.models.Auditorium;
import ru.itis.models.Movie;
import ru.itis.models.Reservation;
import ru.itis.models.Screening;
import ru.itis.repositories.*;
import ru.itis.services.MovieService;
import ru.itis.services.MovieServiceImpl;
import ru.itis.services.ReservationService;
import ru.itis.services.ReservationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "reservation", urlPatterns = {"/reservation"})
public class ReservationFreemarkerServlet extends HttpServlet {
    private static final String ADD_USER_VIEW = "ftl/addMovie.ftl";
    private static final String UPDATE_USER_VIEW = "ftl/updateMovie.ftl";
    private static final String LIST_USERS_VIEW = "ftl/movieList.ftl";

    private ReservationService reservationService;
    private ReservationRepository reservationRepository;
    MovieRepository movieRepository;
    ScreeningRepository screeningRepository;
    AuditoriumRepository auditoriumRepository;
    EmployeeRepository employeeRepository;
    ReserationTypeRep reserationTypeRep;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cinematest");
        ReservationRepository reservationRepository = new ReservationRepositoryJbdcImpl(dataSource, screeningRepository, employeeRepository, reserationTypeRep);
        this.reservationService = new ReservationServiceImpl(reservationRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Reservation> reservations = reservationService.getReservation();
        List<Auditorium> auditoriumList = auditoriumRepository.findAll();


        req.setAttribute("reservations", reservations);
        req.setAttribute("auditoriumList", auditoriumList);

        String action = req.getParameter("action");
        String DELETE_ACTION = "deleteReservation";
        String ADD_ACTION = "addReservation";
        String EDIT_ACTION = "editReservation";
        String path = "";
        if (DELETE_ACTION.equals(action)) {
            Long id_reservation = Long.parseLong(req.getParameter("id_reservation"));
            reservationService.deleteReservation(id_reservation);
        } else if (EDIT_ACTION.equals(action)) {
            Long id_reservation = Long.parseLong(req.getParameter("id_reservation"));
            Reservation reservation = reservationService.getReservation(id_reservation);
            req.setAttribute("reservations", reservation);
            path = UPDATE_USER_VIEW;
        } else if (ADD_ACTION.equals(action)) {
            path = ADD_USER_VIEW;
        } else {
            path = "/ftl/reservation.ftl";
        }
        req.getRequestDispatcher("web/index.html").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String ADD_ACTION = "addReservation";

    }
}

