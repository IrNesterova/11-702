import lombok.SneakyThrows;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    //language=sql
    public static final String insertFirst = "Insert into dna_1(gnomeby2_1, gnomeby5_1, gnomeby9_1) VALUES " +
            "(?,?,?)";
    //language=sql
    public static final String insertSecond = "Insert into dna_2(gnomeby2_2, gnomeby5_2, gnomeby9_2) VALUES " +
            "(?,?,?)";

    @SneakyThrows
    public static ArrayList<String> parse(File file, int partLength) {
        Scanner scanner = new Scanner(file);
        String buff = "";
        scanner.useDelimiter("");
        ArrayList<String> list = new ArrayList<>();
        while (scanner.hasNext()) {
            String n = scanner.next();
            if (n.equals("\n")) {
                continue;
            }
            buff += n;
            if (buff.length() == partLength) {
                list.add(buff);
                buff = buff.substring(1);
            }
        }
        return list;
    }

    @SneakyThrows
    public static void main(String[] args) throws IOException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "qwerty007");
        File first = new File("C:\\Users\\Justice\\Desktop\\11-702\\parseShinglesDatabase\\src\\main\\java\\Genome_1.txt");
        File second = new File("C:\\Users\\Justice\\Desktop\\11-702\\parseShinglesDatabase\\src\\main\\java\\Genome_2.txt");
        ArrayList<String> genome_one_two;
        ArrayList<String> genome_one_five;
        ArrayList<String> genome_one_nine;
        ArrayList<String> genome_two_two;
        ArrayList<String> genome_two_five;
        ArrayList<String> genome_two_nine;
        genome_one_two = parse(first, 2);
        genome_one_five = parse(first, 5);
        genome_one_nine = parse(first, 9);
        genome_two_two = parse(second, 2);
        genome_two_five = parse(second, 5);
        genome_two_nine = parse(second, 9);
        int index = 0;
        for (String str : genome_one_two) {
            PreparedStatement statement = connection.prepareStatement(insertFirst);
            statement.setString(1, str);
            try {
                statement.setString(2, genome_one_five.get(index));
            } catch (IndexOutOfBoundsException e) {
                statement.setString(2, null);
            }
            try {
                statement.setString(3, genome_one_nine.get(index));
            } catch (IndexOutOfBoundsException e) {
                statement.setString(3, null);
            }
            statement.executeUpdate();
            index++;
        }
        index = 0;

        for (String str : genome_two_two) {
            PreparedStatement statement = connection.prepareStatement(insertSecond);
            statement.setString(1, str);
            try {
                statement.setString(2, genome_two_five.get(index));
            } catch (IndexOutOfBoundsException e) {
                statement.setString(2, null);
            }
            try {
                statement.setString(3, genome_two_nine.get(index));
            } catch (IndexOutOfBoundsException e) {
                statement.setString(3, null);
            }
            statement.executeUpdate();
            index++;
        }
    }
}
