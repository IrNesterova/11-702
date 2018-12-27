package cinema.services;

import cinema.Models.Employee;
import cinema.Models.movie;

import java.sql.Time;
import java.sql.Timestamp;

public interface EmployeeService {
    void register(String username, String password);
    void makeReservation(String movieTitle, String auditoriumName, Timestamp screening_start,
                         int row, int seat, boolean reserved);
    void sellTickets(String movieTitle, String auditoruimName, Timestamp screening_start,
                     int row, int seat, boolean paid);
    void trackFreeSeats(String auditoriumName);
    void changeMovieStart(String movieTitle, Timestamp screening_start, String auditoriumName);

}
