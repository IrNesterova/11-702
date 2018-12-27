package ru.itis.servlets;

import lombok.SneakyThrows;
import ru.itis.forms.RegistrationForm;
import ru.itis.repositories.UsersRepository;
import ru.itis.services.UsersService;
import ru.itis.repositories.UsersRepositoryJbdcImpl;
import ru.itis.services.UsersServiceImpl;

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

@WebServlet("/signUp")
public class SignUpServlet extends HttpServlet{
    private UsersService usersService;

    @Override
    @SneakyThrows
    public void init() throws ServletException {
        Class.forName("org.postgresql.Driver");
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\Justice\\Desktop\\11-702\\ShoppingCartDatabase\\src\\main\\resources\\ru.itis\\application.properties"));
        Connection connection =
                DriverManager.getConnection(properties.getProperty("db.url"),
                        properties.getProperty("db.user"),
                        properties.getProperty("db.password"));
        UsersRepository usersRepository = new UsersRepositoryJbdcImpl(connection);
        usersService = new UsersServiceImpl(usersRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/signUp.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RegistrationForm registrationForm = RegistrationForm.builder()
                .first_name(req.getParameter("first_name"))
                .last_name(req.getParameter("last_name"))
                .login(req.getParameter("login"))
                .email(req.getParameter("email"))
                .password(req.getParameter("password"))
                .secretQuestion(req.getParameter("secretquestion"))
                .secretAnswer(req.getParameter("secretanswer"))
                .build();
        usersService.signUp(registrationForm);
        resp.sendRedirect("/signUp");
    }
}
