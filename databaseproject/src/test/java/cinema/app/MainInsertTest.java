package cinema.app;

import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class MainInsertTest {
    @SneakyThrows
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\Justice\\Desktop\\11-702\\databaseproject\\src\\main\\resources\\cinema\\application.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"));
        Scanner scanner = new Scanner(System.in);
        Long id_movie = scanner.nextLong();
        String title = scanner.nextLine();
        String description = scanner.nextLine();
        String director = scanner.nextLine();
        String actors = scanner.nextLine();
        String duration_min = scanner.nextLine();
        PreparedStatement statement = connection.prepareStatement(
                "insert into movie(id_movie, title, description, director, actors, duration_min) values (?,?,?,?,?,?)"
        );
        statement.setLong(1, id_movie);
        statement.setString(2,title);
        statement.setString(3,description);
        statement.setString(4,director);
        statement.setString(5, actors);
        statement.setString(6, duration_min);
        statement.executeUpdate();
    }
}
