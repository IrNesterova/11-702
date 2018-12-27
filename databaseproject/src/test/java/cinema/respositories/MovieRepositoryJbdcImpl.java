package cinema.respositories;

import cinema.Models.Employee;
import cinema.Models.movie;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;
import java.util.Optional;

public class MovieRepositoryJbdcImpl implements MovieRepository {
    private Connection connection;

    //language=sql
    private static final String SQL_FIND_BY_ID="SELECT * from movie where id = ?";

    //language=sql
    private static final String SQL_UPDATE_BY_ID = "update movie SET title = ?,"+"director = ?, description = ?," +
            " actors = ?, duration_min = ? where id = ?;";
    //language=sql
    private static final String SQL_INSERT_MOVIE = "insert into movie(title, director, description, actors, duration_min) values(?,?,?,?,?)";

    private PreparedStatement findByIdStatement;
    private PreparedStatement updateByIdStatement;
    private PreparedStatement insertStatement;
    @SneakyThrows
    public MovieRepositoryJbdcImpl(Connection connection){
        this.connection = connection;
        findByIdStatement = connection.prepareStatement(SQL_FIND_BY_ID);
        updateByIdStatement = connection.prepareStatement(SQL_UPDATE_BY_ID);
        insertStatement = connection.prepareStatement(SQL_INSERT_MOVIE);
    }

    @Override
    public Optional<movie> findByTitle(String title) {
        return Optional.empty();
    }

    @Override
    public Optional<movie> findbyDirector(String director) {
        return null;
    }

    @Override
    public Optional<movie> findbyActors(String actors) {
        return null;
    }

    @Override
    public Optional<movie> findbyDuration(int duration_min) {
        return null;
    }

    @Override
    @SneakyThrows
    public void create(movie model) {
        insertStatement.setLong(1,model.getId_movie());
        insertStatement.setString(2, model.getTitle());
        insertStatement.setString(3, model.getDirector());
        insertStatement.setString(4, model.getDescription());
        insertStatement.setString(5, model.getActors());


        int affectedRows = updateByIdStatement.executeUpdate();
        if(affectedRows !=1){
            throw new IllegalArgumentException("SQL Exception");
        }
    }

    @Override
    public void update(movie model) {

    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    @SneakyThrows
    public movie findOne(Integer id_movie) {
        findByIdStatement.setLong(1, id_movie);
        ResultSet resultSet = findByIdStatement.executeQuery();
        resultSet.next();
        return movie.builder()
                .id_movie(resultSet.getLong("id_movie"))
                .actors(resultSet.getString("actors"))
                .director(resultSet.getString("director"))
                .title(resultSet.getString("title"))
                .description(resultSet.getString("description"))
                .duration_min(resultSet.getString("duration_min"))
                .build();

    }

    @Override
    public List<movie> findAll() {
        return null;
    }
}
