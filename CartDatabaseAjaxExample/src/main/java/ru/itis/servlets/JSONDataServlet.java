package ru.itis.servlets;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Cart;
import ru.itis.repositories.*;
import ru.itis.services.LoginService;
import ru.itis.services.LoginServiceImpl;
import ru.itis.services.ShopService;
import ru.itis.services.ShopServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/catalog.json")
public class JSONDataServlet extends HttpServlet{
    private AuthRepository authRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;
    private CartRepository cartRepository;

    private LoginService loginService;
    private ShopService shopService;
    private ObjectMapper mapper = new ObjectMapper();

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test");

        userRepository = new UsersRepositoryJdbcTemplateImpl(dataSource);
        authRepository = new AuthRepositoryImpl(dataSource);
        cartRepository = new CartRepositoryImpl(dataSource);
        productRepository = new ProductsRepositoryJbdcTemplateImpl(dataSource);
        loginService = new LoginServiceImpl(authRepository, userRepository);
        shopService = new ShopServiceImpl(cartRepository, productRepository);
    }

    @Override
    @SneakyThrows
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[]cookies = req.getCookies();
        if (cookies == null){
            cookies = new Cookie[0];
        }
        Cart cart = shopService.getUserCart(loginService, cookies);
        String resultJson = mapper.writeValueAsString(cart.getProductsCount());
        resp.setStatus(200);
        resp.setContentType("application/json");
        PrintWriter writer = resp.getWriter();
        writer.write(resultJson);
    }
}
