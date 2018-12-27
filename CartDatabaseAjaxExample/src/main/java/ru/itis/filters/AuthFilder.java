package ru.itis.filters;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.repositories.AuthRepository;
import ru.itis.repositories.AuthRepositoryImpl;
import ru.itis.repositories.UserRepository;
import ru.itis.repositories.UsersRepositoryJdbcTemplateImpl;
import ru.itis.services.LoginService;
import ru.itis.services.LoginServiceImpl;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/catalog")

public class AuthFilder implements Filter {
    private static LoginService service;
    @Override
    public void init(FilterConfig filterConfig) {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
        UserRepository usersRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        AuthRepository authRepository = new AuthRepositoryImpl(dataSource);
        service = new LoginServiceImpl(authRepository, usersRepository);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        Cookie cookies[] = request.getCookies();

        boolean exists = false;

        if(cookies == null)
            cookies = new Cookie[0];

        for(Cookie cookie : cookies){
            if(cookie.getName().equals("auth")){
                if (!service.isExistByCookie(cookie.getValue())) {
                    response.sendRedirect("/login");
                    return;
                }
                else{
                    exists = true;
                }
            }
        }
        if (!exists) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
