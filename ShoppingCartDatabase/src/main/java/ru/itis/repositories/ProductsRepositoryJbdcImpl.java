package ru.itis.repositories;

import lombok.SneakyThrows;
import ru.itis.models.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.Optional;

public class ProductsRepositoryJbdcImpl implements ProductsRepository {
    Connection connection;

    //language=sql
    private static final String SQL_FIND_BY_ID = "SELECT * from products" +
            "where id = ?";
    //language=sql
    private static final String SQL_UPDATE_BY_ID =
            "update products set title = ?, slug = ?, description =?," +
                    "price =?, image = ?, stock = ?, updated_at = ?, id = ?";
    //language=sql
    private static final String SQL_INSERT_PRODUCT =
            "insert into products(title, slug , description, price, image," +
                    "stock, created_at) VALUES (?,?,?,?,?,?,?)";
    private PreparedStatement findByIdStatement;
    private PreparedStatement updateByIdStatement;
    private PreparedStatement insertStatement;

    @SneakyThrows
    public ProductsRepositoryJbdcImpl(Connection connection) {
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
        updateByIdStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
        insertStatement = connection.prepareStatement(SQL_INSERT_PRODUCT);
    }
    @Override
    @SneakyThrows
    public void save(Product model) {
        insertStatement.setString(1, model.getTitle());
        insertStatement.setString(2, model.getSlug());
        insertStatement.setString(3, model.getDescription());
        insertStatement.setString(4, model.getPrice());
        insertStatement.setString(5, model.getImage());
        insertStatement.setInt(6, model.getStock());
        insertStatement.setTimestamp(7, model.getCreated_at());
        int affectedRows = insertStatement.executeUpdate();
        if (affectedRows != 1) {
            throw new IllegalArgumentException("SQL Exception");
        }
    }

    @Override
    @SneakyThrows
    public void update(Product model) {
        updateByIdStatement.setString(1, model.getTitle());
        updateByIdStatement.setString(2, model.getSlug());
        updateByIdStatement.setString(3, model.getDescription());
        updateByIdStatement.setString(4, model.getPrice());
        updateByIdStatement.setString(5, model.getImage());
        updateByIdStatement.setInt(6, model.getStock());
        updateByIdStatement.setTimestamp(7, model.getUpdated_at());
        updateByIdStatement.setLong(8, model.getId());
        int affectedRows = updateByIdStatement.executeUpdate();
        if (affectedRows != 1) {
            throw new IllegalArgumentException("SQL Exception");
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Product findOne(Long id) {
        return null;
    }

    @Override
    public List findAll() {
        return null;
    }

    @Override
    public Optional<Product> findByPrice(String price) {
        return null;
    }
}
