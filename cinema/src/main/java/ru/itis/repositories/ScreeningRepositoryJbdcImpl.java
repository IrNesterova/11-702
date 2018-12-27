package ru.itis.repositories;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Screening;
import ru.itis.services.AuditoriumService;
import ru.itis.services.MovieService;

import javax.sql.DataSource;
import java.util.List;
import java.util.Optional;

public class ScreeningRepositoryJbdcImpl implements ScreeningRepository {
    JdbcTemplate template;
    private MovieRepository movieRepository;
    private AuditoriumRepository auditoriumRepository;
    public ScreeningRepositoryJbdcImpl(DataSource dataSource, MovieRepository movieRepository, AuditoriumRepository auditoriumRepository){
        this.auditoriumRepository = auditoriumRepository;
        this.movieRepository = movieRepository;
        this.template = new JdbcTemplate(dataSource);
    }

    //language=sql
    private static final String SQL_FIND_MOVIE= "select screening_start, title from screening, movie where id_movie=movie.id_movie";
    //language=sql
    private static final String SQL_SELECT_SCREENING_BY_MOVIE_ID =
             "select * from screening where id_movie = ?";
    //language=sql
    private static final String SQL_SELECT_AUDITORIUM_BY_ID = "select screening_start, name from screening, auditorium where auditorium_id = auditorium.id_auditorium";

    //language=sql
    private static final String SQL_SELECT_ALL_SCREENING =
            "select * from screening";
    //language=sql
    private static final String SQL_INSERT_SCREENING =
            "insert into screening(id_screening, id_movie, auditorium_id, screening_start) VALUES (?,?,?,?)";
    //language=sql
    private static final String SQL_SELECT_BY_SCREENING_START =
            "select * from screening where screening_start < TIME";
    //language sql
    private static final String SQL_FIND_BY_ID =
            "select * from screening where id_screening = ?";

    private RowMapper<Screening> screeningRowMapper = (resultSet, i) -> Screening.builder()
            .id_screening(resultSet.getLong("id_screening"))
            .id_movie(movieRepository.findOne(resultSet.getLong("id_movie")).getTitle())
            .auditorium_id(auditoriumRepository.findOne(resultSet.getLong("auditorium_id")).getName())
            .screening_start(resultSet.getTimestamp("screening_start"))
            .build();



    @Override
    public void save(Screening model) {
        //language = sql
       template.update(SQL_INSERT_SCREENING, screeningRowMapper);
    }

    @Override
    public void update(Screening model) {
        //language = sql
        String sql = "update screening set id_movie='"+
                model.getId_movie()+"',auditorium_id='"+model.getAuditorium_id()+"'screening_start='"+
                model.getScreening_start() + "'where id_screening='" + model.getId_screening()+"'";
        template.update(sql);
    }

    @Override
    public void delete(Long id) {
        //language = sql
        String sql = "delete from screening where id_screening ="+id;
        template.update(sql);
    }

    @Override
    public Screening findOne(Long id) {
        return template.queryForObject(SQL_FIND_BY_ID, screeningRowMapper);
    }

    @Override
    public List<Screening> findAll() {
       return template.query(SQL_SELECT_ALL_SCREENING, screeningRowMapper);
    }

    @Override
    public Optional<Screening> findByMovieId(Long movie_id) {
        try {

            return Optional.of(template.queryForObject(SQL_SELECT_SCREENING_BY_MOVIE_ID, screeningRowMapper, movie_id));
        } catch (EmptyResultDataAccessException e ){
            return Optional.empty();
        }
    }

    @Override
    public List<Screening> getMovieTitle(Long movie_id) {
        return template.query(SQL_SELECT_SCREENING_BY_MOVIE_ID, screeningRowMapper);
    }

}
