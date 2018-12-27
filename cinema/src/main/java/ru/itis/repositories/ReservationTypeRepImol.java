package ru.itis.repositories;

import org.springframework.jdbc.core.JdbcTemplate;
import ru.itis.models.Reservation_type;

import javax.sql.DataSource;
import javax.swing.tree.RowMapper;
import javax.xml.crypto.Data;
import java.sql.JDBCType;
import java.util.List;

public class ReservationTypeRepImol implements ReserationTypeRep {
    JdbcTemplate template;
    public ReservationTypeRepImol(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }
    public org.springframework.jdbc.core.RowMapper<Reservation_type> reservation_typeRowMapper = (resultSet, i) -> Reservation_type.builder()
            .id(resultSet.getLong("id_reservation_type"))
            .reservation_type(resultSet.getString("reservation_type"))
            .build();

    //language=sql
    private static final String SQL_SELECT_FROM_RES_TYPE = "select * from reservation_type";
    //language=sql
    private static final String SQL_SELECT_BY_ID = "select * from reservation_type where id_reservation_type = ?";
    @Override
    public void getReservationType(Long id) {
        template.queryForObject(SQL_SELECT_BY_ID, reservation_typeRowMapper, id);
    }

    @Override
    public void save(Reservation_type model) {

    }

    @Override
    public void update(Reservation_type model) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Reservation_type findOne(Long id) {
        return null;
    }

    @Override
    public List<Reservation_type> findAll() {
        return null;
    }
}
