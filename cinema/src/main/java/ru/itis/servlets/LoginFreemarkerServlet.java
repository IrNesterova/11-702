package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.forms.LoginForm;
import ru.itis.models.Employee;
import ru.itis.repositories.*;
import ru.itis.services.LoginService;
import ru.itis.services.LoginServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginFreemarkerServlet extends HttpServlet{
    private LoginService loginService;

    private AdminRepository adminRepository;
    private AuthRepository authRepository;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5433/cinematest");
        adminRepository = new AdminRepositoryJdbcImpl(dataSource);
        authRepository = new AuthRepositoryImpl(dataSource);
        loginService = new LoginServiceImpl(adminRepository, authRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ftl/login.ftl").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        LoginForm loginForm = LoginForm.builder()
                .username(name)
                .password(password)
                .build();
        Optional<String> optionalCookieValue = loginService.login(loginForm);
        if (optionalCookieValue.isPresent()){
            Cookie cookie = new Cookie("auth", optionalCookieValue.get());
            resp.addCookie(cookie);
            resp.setStatus(201);
            resp.sendRedirect("movieList");

        } else {
            resp.setStatus(403);
        };
    }
}
