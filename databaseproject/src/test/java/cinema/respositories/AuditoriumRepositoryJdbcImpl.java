package cinema.respositories;

import cinema.Models.auditorium;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class AuditoriumRepositoryJdbcImpl implements AuditoriumRepository {
    private Connection connection;
    private static final String SQL_FIND_BY_ID="SELECT * from employee where id = ?";

    private PreparedStatement findByIdStatement;

    @SneakyThrows
    public AuditoriumRepositoryJdbcImpl(Connection connection){
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
    }

    @Override
    public Optional<auditorium> findReservedSeats(int row, int seats) {
        return null;
    }

    @Override
    public Optional<auditorium> findPaidSeats(int row, int seats) {
        return null;
    }

    @Override
    public Optional<auditorium> findFreeSeats(int row, int seats) {
        return null;
    }

    @Override
    public void create(auditorium model) {

    }

    @Override
    public void update(auditorium model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    @SneakyThrows
    public auditorium findOne(Integer id) {
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();
        resultSet.next();
        return auditorium.builder()
                .id(resultSet.getLong("id"))
                .name(resultSet.getString("name"))
                .build();
    }

    @Override
    public List<auditorium> findAll() {
        return null;
    }
}
