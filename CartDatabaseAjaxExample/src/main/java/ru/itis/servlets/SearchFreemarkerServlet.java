package ru.itis.servlets;


import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.itis.models.Product;
import ru.itis.repositories.ProductRepository;
import ru.itis.repositories.ProductsRepositoryJbdcTemplateImpl;
import ru.itis.services.SearchService;
import ru.itis.services.SearchServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/search/ftl")
public class SearchFreemarkerServlet extends HttpServlet {
    private SearchService searchService;

    @Override
    public void init() throws ServletException {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("org.postgresql.Driver");
        dataSource.setUsername("postgres");
        dataSource.setPassword("qwerty007");
        dataSource.setUrl("jdbc:postgresql://localhost:5432/test");
        ProductRepository productRepository = new ProductsRepositoryJbdcTemplateImpl(dataSource);
        this.searchService = new SearchServiceImpl(productRepository);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("q");
        if (query != null){
            List<Product> products = searchService.search(query);
            req.setAttribute("products" ,products);
            req.getRequestDispatcher("/ftl/search.ftl").forward(req, resp);
        } else {
            req.getRequestDispatcher("/ftl/search.ftl");
        }
    }
}
