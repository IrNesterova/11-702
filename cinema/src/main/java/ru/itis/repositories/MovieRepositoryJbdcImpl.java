package ru.itis.repositories;

import lombok.Data;
import lombok.SneakyThrows;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import ru.itis.models.Auditorium;
import ru.itis.models.Movie;
import ru.itis.models.Screening;
import ru.itis.models.Seat;


import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieRepositoryJbdcImpl implements MovieRepository{

    JdbcTemplate template;
    Connection connection;

    public MovieRepositoryJbdcImpl(DataSource dataSource){
        this.template = new JdbcTemplate(dataSource);
    }

    //language = sql
    private static final String SQL_SELECT_MOVIE_BY_ID =
            "select * from movie where id_movie = ?";
    //language = sql
    private static final String SQL_GET_MOVIE_AND_SCREENING_AND_HOPEFULLY_AUDITORIUMWITHSEATS =
            "select movie.id_movie, movie.title, movie.director, movie.actors, movie.description, movie.duration_min, movie.ratings, movie.posteraddress, screening.screening_start from movie, screening where movie.id_movie = screening.id_movie";
    //language = sql
    private static final String SQL_SEARCH = "select * from movie where movie.title ilike ?";

    //language = sql
    private static final String SQL_ALL_SEATS = "select * from seat";
    //language = sql
    private static final String SQL_ALL_MOVIES = "select * from movie";
    //language = sql
    private static final String SQL_INSERT_MOVIE =
            "insert into movie(id_movie, title, director, actors, description, duration_min, ratings, posteraddress) values (?,?,?,?,?,?,?,?)";

    //language = sql
    private static final String SQL_SEARCH_BY_DIRECTOR = "select * from movie where movie.director ilike ?";
    private RowMapper<Movie> userMovie = (resultSet, i) ->Movie.builder()
            .id_movie(resultSet.getLong("id_movie"))
            .title(resultSet.getString("title"))
            .director(resultSet.getString("director"))
            .actors(resultSet.getString("actors"))
            .description(resultSet.getString("description"))
            .duration_min(resultSet.getString("duration_min"))
            .ratings(resultSet.getString("ratings"))
            .posterAddress(resultSet.getString("posteraddress"))
            .build();


    @Override
    public List<Movie> findAllByTitleSearch(String title) {
        return template.query(SQL_SEARCH, userMovie, "%" + title + "%");
    }

    @Override
    public List<Movie> findAllByDirectorSearch(String director) {
        return template.query(SQL_SEARCH_BY_DIRECTOR, userMovie, "%" + director + "%");
    }

    @Override
    public List<Movie> getAllScreening(Long id) {
        return null;
    }


    @Override
    public void save(Movie model) {
        template.update(SQL_INSERT_MOVIE, model.getId_movie(), model.getTitle(), model.getDirector(), model.getActors(), model.getDescription(), model.getDuration_min(), model.getRatings(), model.getPosterAddress());
    }

    @Override
    public void update(Movie model) {
        //language=sql
        String sql = "update movie set title =' " + model.getTitle() + "', director" +
                model.getDirector() + "', actors" + model.getActors() + "', descriprion"
                + model.getDescription() + "', duration_min" + model.getDuration_min()
                + "',ratings" + model.getRatings() + "', posterAddress" + model.getPosterAddress() + "'where id_movie='"+model.getId_movie() + "''";
        System.out.println(sql);
        template.update(sql);
    }

    @Override
    public void delete(Long id) {
        //language=sql
        String sql = "delete from movie where id_movie = " + id;
        template.update(sql);
    }

    @Override
    public Movie findOne(Long id) {
       return template.queryForObject(SQL_SELECT_MOVIE_BY_ID, userMovie, id);
    }

    @Override
    public List<Movie> findAll() {
       return template.query(SQL_ALL_MOVIES, userMovie);
    }

}
