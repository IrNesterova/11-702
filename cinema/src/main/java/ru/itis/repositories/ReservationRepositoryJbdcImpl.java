package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.*;


import javax.sql.DataSource;
import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public class ReservationRepositoryJbdcImpl implements ReservationRepository {
    JdbcTemplate template;
    private ScreeningRepository screeningRepository;
    private EmployeeRepository employeeRepository;
    private ReserationTypeRep reservationTypeRep;
    public ReservationRepositoryJbdcImpl(DataSource dataSource, ScreeningRepository screeningRepository, EmployeeRepository employeeRepository, ReserationTypeRep reservationTypeRep){
        this.template = new JdbcTemplate(dataSource);
        this.screeningRepository = screeningRepository;
        this.employeeRepository = employeeRepository;
        this.reservationTypeRep = reservationTypeRep;
    }

    //language = sql
    private final String SQL_FIND_REPOSITORY_BY_CONTACT =
            "select * from reservation where reservation_contact = ?";
    //language = sql
    private final String SQL_FIND_REPOSITORY_BY_SCREENING_ID =
            "select * from reservation where screening_id = ?";
    //language = sql
    private final String SQL_FIND_REPOSITORY_BY_ID =
            "select * from reservation where id_reservation = ?";
    //language = sql
    private final String SQL_FIND_REP_BY_TYPE_ID =
            "select * from reservation where reservation_type_id = ?";
    //language = sql
    private final String SQL_INSERT_INTO_RESERVATION =
            "insert into reservation(screening_id, employee_reserved_id, resevation_type_id, reservation_contact, reserved, employee_paid_id, paid, active) values" +
                    "(?,?,?,?,?,?,?,?,?)";

    Reservation_type reservation_type;
    //language=sql
    private static final String SQL_SELECT_REP_AND_SEAT_AND_AUD = "select screening_id, employee_reserved_id, employee_paid_id, reservation_contact," +
            " reservation_type, active, reserved, paid, seat.row, seat.number, " +
            "auditorium.name, movie.title, screening.screening_start from reservation, seat_reserved, seat," +
            " screening, auditorium, movie where seat_reserved.reservaton_id = reservation.id" +
            " AND seat_reserved.seat_id = seat.id_seat AND" +
            " seat_reserved.screening_id = screening.id_screening AND" +
            " screening.id_movie = movie.id_movie and seat.auditorium_id = auditorium.id_auditorium";
    //language=sql
    private final String SQL_SELECT_ALL =
            "select * from reservation";
    private RowMapper<Reservation> reservationRowMapper = (resultSet, i) -> Reservation.builder()
            .id(resultSet.getLong("id_reservation"))
            .screening_id_start(screeningRepository.findOne(resultSet.getLong("screening_id")).getScreening_start())
            .employee_reserved_id_name(employeeRepository.findOne(resultSet.getLong("employee_reserved_id")).getLast_name())
            .employee_paid_id_name(employeeRepository.findOne(resultSet.getLong("employee_paid_id")).getLast_name())
            .reservation_contact(resultSet.getString("reservation_contact"))
            .reservation_type_id(reservationTypeRep.findOne(resultSet.getLong("reservation_type_id")).getReservation_type())
            .reserved(resultSet.getBoolean("reserved"))
            .active(resultSet.getBoolean("active"))
            .paid(resultSet.getBoolean("paid"))
            .build();
    private RowMapper<seat_reserved> reservedRowMapper = (resultSet, i) -> seat_reserved.builder()
            .id_seat_reserved(resultSet.getLong("id_seat_reserved"))
            .screening_id(screeningRepository.findOne(resultSet.getLong("screening_id")).getId_screening())
            .seat_id(resultSet.getLong("seat_id"))
            .reservation(this.findOne(resultSet.getLong("reservation_id")))
            .build();


    @Override
    public void save(Reservation model) {
        template.update(SQL_INSERT_INTO_RESERVATION, model.getId());
    }

    @Override
    public void update(Reservation model) {

    }


    @Override
    public void delete(Long id) {
        //language=sql
        String sql = "delete from reservation where id = ?";
        template.update(sql);
    }

    @Override
    public Reservation findOne(Long id) {
        return template.queryForObject(SQL_FIND_REPOSITORY_BY_ID, reservationRowMapper, id);
    }

    @Override
    public List<Reservation> findAll() {
        return template.query(SQL_SELECT_REP_AND_SEAT_AND_AUD, reservationRowMapper);
    }

    @Override
    public Optional<Reservation> findByContact(String contact) {
        try {
            return Optional.of(template.queryForObject(SQL_FIND_REPOSITORY_BY_CONTACT, reservationRowMapper));
        } catch (EmptyResultDataAccessException e) {
            return Optional.empty();
        }
    }

    @Override
    public boolean isActive(Boolean active) {
        return false;
    }
}
