package ru.itis.repositories;

import lombok.SneakyThrows;
import ru.itis.models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class UsersRepositoryJbdcImpl implements UsersRepository {
    Connection connection;
    //language=sql
    private static final String SQL_FIND_BY_ID =
            "SELECT * FROM customers WHERE ID = ?";
    //language=sql
    private static final String SQL_INSERT_USER =
            "insert into customers(first_name, last_name, login, email, hashpassword, secretquestion, secretanswer) VALUES " +
                    "(?,?,?,?,?,?,?)";
    //language=sql
    private static final String SQL_UPDATE_BY_ID =
            "update customers set first_name = ?," +
                    "last_name = ?, email = ?, login = ? where id = ?";
    private PreparedStatement findByIdStatement;
    private PreparedStatement updateByIdStatement;
    private PreparedStatement insertStatement;

    @SneakyThrows
    public UsersRepositoryJbdcImpl(Connection connection) {
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
        updateByIdStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
        insertStatement = connection.prepareStatement(SQL_INSERT_USER);
    }

    @Override
    public Optional<User> findByPhone(String phone) {
        return null;
    }

    @Override
    @SneakyThrows
    public void save(User model) {
        insertStatement.setString(1, model.getFirst_name());
        insertStatement.setString(2, model.getLast_name());
        insertStatement.setString(3, model.getEmail());
        insertStatement.setString(4, model.getLogin());
        insertStatement.setString(5, model.getPassword());
        insertStatement.setString(6, model.getSecretQuestion());
        insertStatement.setString(7, model.getSecretAnswer());
        int affectedRows = insertStatement.executeUpdate();
        if (affectedRows != 1) {
            throw new IllegalArgumentException("SQL Exception");
        }
    }

    @Override
    @SneakyThrows
    public void update(User model) {
        updateByIdStatement.setString(1, model.getFirst_name());
        updateByIdStatement.setString(2, model.getLast_name());
        updateByIdStatement.setString(3, model.getEmail());
        updateByIdStatement.setString(4, model.getLogin());
        int affectedRows = updateByIdStatement.executeUpdate();
        if (affectedRows != 1) {
            throw new IllegalArgumentException("SQL Exception");
        }
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    @SneakyThrows
    public User findOne(Long id) {
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();
        resultSet.next();
        return User.builder()
                .id(resultSet.getLong("id"))
                .first_name(resultSet.getString("first_name"))
                .last_name(resultSet.getString("last_name"))
                .email(resultSet.getString("email"))
                .login(resultSet.getString("login"))
                .build();

    }
    @Override
    public List<User> findAll() {
        return null;
    }
}
