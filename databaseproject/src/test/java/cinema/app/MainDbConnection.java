package cinema.app;

import cinema.Models.Employee;
import lombok.SneakyThrows;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class MainDbConnection {
    @SneakyThrows
    public static void main(String[] args) {
        Properties properties = new Properties();
        properties.load(new FileReader("C:\\Users\\Justice\\Desktop\\11-702\\databaseproject\\src\\main\\resources\\cinema\\application.properties"));
        Connection connection = DriverManager.getConnection(properties.getProperty("db.url"), properties.getProperty("db.user"), properties.getProperty("db.password"));
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from employee");
        while (resultSet.next()){
            Employee employee = Employee.builder()
                    .id(resultSet.getLong("id"))
                    .username(resultSet.getString("username"))
                    .hashPassword(resultSet.getString("password"))
                    .build();
            System.out.print(employee);
        }
    }
}
