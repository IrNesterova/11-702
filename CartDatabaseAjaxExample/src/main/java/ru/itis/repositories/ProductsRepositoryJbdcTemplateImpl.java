package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Product;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.util.List;

public class ProductsRepositoryJbdcTemplateImpl implements ProductRepository {
    private JdbcTemplate jdbcTemplate;

    //language=sql
    private static final String SQL_SEARCH = "SELECT * from product where product.name ilike ?";
    //language=sql
    private static final String SQL_SELECT_PRODUCT_BY_ID =
            "select * from product where id = ?";
    //language=sql
    private static final String SQL_SELECT_ALL_THINGS =
            "select * from product";
    //language=sql
    private static final String SQL_SELECT_BY_NAME=
            "select * from product where name = ?";
    //language=sql
    private static final String SQL_INSERT_PRODUCT =
            "insert into product(name, price)  VALUES (?, ?)";
    //language = sql
    private static final String SQL_DELETE_PRODUCT =
            "delete * from product where id = ?";

    private RowMapper<Product> productRowMapper = (resultSet, i) -> Product.builder()
            .id(resultSet.getLong("id"))
            .name(resultSet.getString("name"))
            .price(resultSet.getString("price"))
            .build();


    public ProductsRepositoryJbdcTemplateImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public Product findByName(String name) {
        try{
            return jdbcTemplate.queryForObject(SQL_SELECT_BY_NAME, productRowMapper, name);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Product> findByAllTitleSearch(String table) {
        return jdbcTemplate.query(SQL_SEARCH, productRowMapper, "%" + table + "%");
    }

    @Override
    public List<Product> findAll() {
        return jdbcTemplate.query(SQL_SELECT_ALL_THINGS, productRowMapper);
    }

    @Override
    public Product find(Long id) {
        try {
            return jdbcTemplate.queryForObject(SQL_SELECT_PRODUCT_BY_ID, productRowMapper, id);
        } catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public void save(Product model) {
        jdbcTemplate.update(SQL_INSERT_PRODUCT, model.getName(),model.getPrice());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_DELETE_PRODUCT, productRowMapper, id);
    }

    @Override
    public void update(Product model) {

    }
}
