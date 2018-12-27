package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Employee;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class EmployeeRepositoryJbdcImpl implements EmployeeRepository {
    private JdbcTemplate jdbcTemplate;

    private RowMapper<Employee> employeeRowMapper = (resultSet, i) -> Employee.builder()
            .id((resultSet.getLong("id_employee")))
            .username(resultSet.getString("username"))
            .hashPassword(resultSet.getString("password"))
            .first_name(resultSet.getString("first_name"))
            .last_name(resultSet.getString("last_name"))
            .sex(resultSet.getString("sex"))
            .photo(resultSet.getString("photo"))
            .build();
    //language=sql
    private static final String SQL_SELECT_FROM_EMPLOYEE_BY_ID =
            "select * from employee where id = ?";
    //language=sql
    private static final String SQL_SELECT_FROM_EMPLOYEE =
            "select * from employee";
    private static final String SQL_REMOVE_EMPLOYEE =
            "delete from employee where id = ?";
    private static final String SQL_INSERT_EMPLOYEE =
            "insert into employee(username, password, first_name," +
                    "last_name, sex, photo) values (?,?,?,?,?,?)";
    private static final String SQL_FIND_BY_USERNAME =
            "select * from employee where username = ?";


    public EmployeeRepositoryJbdcImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Override
    public Employee findByUsername(String username) {
        try {

            return jdbcTemplate.queryForObject(SQL_FIND_BY_USERNAME, employeeRowMapper, username);
        } catch (EmptyResultDataAccessException e ){
            return null;
        }
    }

    @Override
    public void save(Employee model) {
        jdbcTemplate.update(SQL_INSERT_EMPLOYEE, model);

    }

    @Override
    public void update(Employee model) {

    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update(SQL_REMOVE_EMPLOYEE, id);
    }

    @Override
    public Employee findOne(Long id) {
        return jdbcTemplate.queryForObject(SQL_SELECT_FROM_EMPLOYEE_BY_ID,
                employeeRowMapper, id);
    }

    @Override
    public List<Employee> findAll() {
        return null;
    }
}
