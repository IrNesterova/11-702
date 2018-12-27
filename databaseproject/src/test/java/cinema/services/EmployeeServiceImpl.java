package cinema.services;

import java.sql.Timestamp;

public class EmployeeServiceImpl implements EmployeeService {
    @Override
    public void register(String username, String password) {

    }

    @Override
    public void makeReservation(String movieTitle, String auditoriumName, Timestamp screening_start, int row, int seat, boolean reserved) {

    }

    @Override
    public void sellTickets(String movieTitle, String auditoruimName, Timestamp screening_start, int row, int seat, boolean paid) {

    }

    @Override
    public void trackFreeSeats(String auditoriumName) {

    }

    @Override
    public void changeMovieStart(String movieTitle, Timestamp screening_start, String auditoriumName) {

    }
}
