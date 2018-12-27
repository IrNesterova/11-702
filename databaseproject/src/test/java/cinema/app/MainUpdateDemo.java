package cinema.app;

import cinema.Models.movie;
import cinema.respositories.MovieRepository;
import cinema.respositories.MovieRepositoryJbdcImpl;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class MainUpdateDemo {
    @SneakyThrows
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\Justice\\Desktop\\11-702\\databaseproject\\src\\main\\resources\\cinema" +
                "\\application.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"),
                properties.getProperty("db.password"));
        MovieRepository movieRepository = new MovieRepositoryJbdcImpl(connection);
        movie Movie = movieRepository.findOne(1);
        System.out.print(Movie);
        Movie.setTitle("Harry Potter and Deathly Hallows");
        movieRepository.update(Movie);
    }
}
