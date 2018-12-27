package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.models.Admin;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import java.util.List;

public class AdminRepositoryJdbcImpl implements AdminRepository {
    private JdbcTemplate jdbcTemplate;
    public AdminRepositoryJdbcImpl(DataSource dataSource){
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    //language=sql
    private static final String SQL_FIND_USERNAME = "select * from admin where username = ?";
    //language=sql
    private static final String SQL_INSERT_ADMIN = "insert into admin(username, password) values(?,?)";
    //language = sql
    private static final String SQL_FIND_BY_ID = "select * from admin where id = ?";
    private org.springframework.jdbc.core.RowMapper<Admin> adminRowMapper = (resultSet, i) -> Admin.builder()
            .id(resultSet.getLong("id"))
            .username(resultSet.getString("username"))
            .password(resultSet.getString("password"))
            .build();
    @Override
    public Admin findByUsername(String name) {
        try {
            return jdbcTemplate.queryForObject(SQL_FIND_USERNAME, adminRowMapper, name);
        } catch (EmptyResultDataAccessException e){
            return null;
        }

    }

    @Override
    public void save(Admin model) {
        jdbcTemplate.update(SQL_INSERT_ADMIN,adminRowMapper,model);
    }

    @Override
    public void update(Admin model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Admin findOne(Long id) {
        return jdbcTemplate.queryForObject(SQL_FIND_BY_ID,
                adminRowMapper, id);
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }
}
