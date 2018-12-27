package cinema.respositories;

import cinema.Models.Employee;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryJbdcImpl implements EmployeeRepository{
    private Connection connection;

    //language=sql
    private static final String SQL_FIND_BY_ID="SELECT * from employee where id = ?";

    private PreparedStatement findByIdStatement;

    @SneakyThrows
    public EmployeeRepositoryJbdcImpl(Connection connection){
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
    }

    @Override
    public Optional<Employee> findByUsername(String username) {
        return Optional.empty();
    }

    @Override
    public void create(Employee model) {

    }

    @Override
    public void update(Employee model) {

    }

    @Override
    public void delete(Integer id) {

    }
    @SneakyThrows
    @Override
    public Employee findOne(Integer id) {
        findByIdStatement.setLong(1, id);
        ResultSet resultSet = findByIdStatement.executeQuery();
        resultSet.next();
        return Employee.builder()
                .id(resultSet.getLong("id"))
                .username(resultSet.getString("username"))
                .hashPassword(resultSet.getString("hashPassword"))
                .build();
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
