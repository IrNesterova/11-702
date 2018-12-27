package ru.itis.app;

import lombok.SneakyThrows;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

public class InsertDemo {
    @SneakyThrows
    public static void main(String[] args) {
        Properties properties = new Properties();

        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/cinematest", "postgres", "qwerty007");
        Scanner scanner = new Scanner(System.in);
        Long id = scanner.nextLong();
        String title = scanner.nextLine();
        String director = scanner.nextLine();
        String actors = scanner.nextLine();
        PreparedStatement statement = connection.prepareStatement("insert into movie(title, director, actors, description, duration_min, ratings, posteraddress) VALUES (?,?,?,?,?,?,?,?)");
        statement.setString(1, title);
        statement.setString(2, director);
        statement.setString(3, actors);
        statement.executeUpdate();
    }
}
