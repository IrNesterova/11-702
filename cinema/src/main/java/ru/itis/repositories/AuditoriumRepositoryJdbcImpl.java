package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Auditorium;
import ru.itis.models.Seat;
import ru.itis.services.AuditoriumService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class AuditoriumRepositoryJdbcImpl implements AuditoriumRepository {
    JdbcTemplate template;
    AuditoriumService service;
    private RowMapper<Auditorium> auditoriumRowMapper = (resultSet, i) -> Auditorium.builder()
            .id(resultSet.getLong("id_auditorium"))
            .name(resultSet.getString("name"))
            .seats_id(resultSet.getInt("seats_no"))
            .build();

    private RowMapper<Seat> seatRowMapper = (resultSet, i) -> Seat.builder()
            .id(resultSet.getLong("id"))
            .row(resultSet.getInt("row"))
            .number(resultSet.getInt("number"))
            .auditorium_id(service.getAudById(resultSet.getLong("id_auditorium")).getName())
            .build();

    public AuditoriumRepositoryJdbcImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    //language=sql
    private final String DELETE = "DELETE from auditorium where id_auditorium = ?";
    //language=sql
    private final String SQL_SELECT_ALL_SEATS = "select row, number from seat where seat.auditorium_id = id_auditorium";

    //language=sql
    private final String SQL_SELECT_BY_ID = "SELECT * from auditorium where id_auditorium = ?";
    //language=sql
    private final String SQL_SELECT_ALL = "select * from auditorium";
    //language=sql
    private final String SQL_INSERT_AUD = "insert into auditorium(id_auditorium, name, seats_no) VALUES (?,?,?)";
    //where seat.id = seat_reserved.seat_id - taken, everything else, no
    @Override
    public Optional<Auditorium> findFreeSeats() {
        return null;
    }

    @Override
    public void save(Auditorium model) {
        template.update(SQL_INSERT_AUD, auditoriumRowMapper);
    }

    @Override
    public void update(Auditorium model) {

    }

    @Override
    public void delete(Long id) {
        template.update(DELETE, auditoriumRowMapper);
    }

    @Override
    public Auditorium findOne(Long id) {
        return template.queryForObject(SQL_SELECT_BY_ID,
                auditoriumRowMapper, id);
    }

    @Override
    public List<Auditorium> findAll() {
        return template.query(SQL_SELECT_ALL, auditoriumRowMapper);
    }
}
