package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.security.core.userdetails.User;
import ru.itis.models.Admin;
import ru.itis.models.Auth;
import ru.itis.models.Employee;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class AuthRepositoryImpl implements AuthRepository {

    //language=SQL
    private static final String SQL_INSERT =
            "insert into auth(user_id, cookievalue) values (?, ?)";

    //language=SQL
    private static final String SQL_SELECT_BY_COOKIE_VALUE =
            "select * from auth where cookievalue = ?";
    //language=SQL
    private static final String SQL_DELETE_COOKIE = "delete from auth where user_id = ?";

    private JdbcTemplate template;

    public AuthRepositoryImpl(DataSource dataSource) {
        this.template = new JdbcTemplate(dataSource);
    }

    private RowMapper<Auth> authRowMapper = (rs, rowNum) -> Auth.builder()
            .id(rs.getLong("user_id"))
            .admin(Admin.builder()
                    .id(rs.getLong("id"))
                    .build())
            .cookieValue(rs.getString("cookievalue"))
            .build();

    @Override
    public List<Auth> findAll() {
        return null;
    }


    @Override
    public void save(Auth model) {
        template.update(SQL_INSERT, model.getAdmin().getId(), model.getCookieValue());
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Auth findOne(Long id) {
        return null;
    }

    @Override
    public void update(Auth model) {

    }

    @Override
    public Optional<Auth> findByCookieValue(String cookieValue) {
        try {
            return Optional.of(template.queryForObject(SQL_SELECT_BY_COOKIE_VALUE, authRowMapper, cookieValue));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public void deleteCookieByUserId(Admin admin) {
        template.update(SQL_DELETE_COOKIE, admin.getId());
    }
}
