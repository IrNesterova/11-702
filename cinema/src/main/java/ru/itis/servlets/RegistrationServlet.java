package ru.itis.servlets;

import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ru.itis.forms.LoginForm;
import ru.itis.repositories.AdminRepository;
import ru.itis.repositories.AdminRepositoryJdbcImpl;
import ru.itis.services.RegistrationService;
import ru.itis.services.RegistrationServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLPermission;

@WebServlet(name = "registration", urlPatterns = {"/registration"})
public class RegistrationServlet extends HttpServlet {
    private BCryptPasswordEncoder encoder;
    private AdminRepository adminRepository;
    private RegistrationService registrationService;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/cinematest");
        encoder = new BCryptPasswordEncoder();
        adminRepository = new AdminRepositoryJdbcImpl(dataSource);
        this.registrationService = new RegistrationServiceImpl(adminRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("ftl/registration.ftl");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String hashPassword = encoder.encode(password);
        LoginForm loginForm = LoginForm.builder()
                .username(username)
                .password(hashPassword)
                .build();
        registrationService.addUser(loginForm);
    }
}
