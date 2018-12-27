package cinema.respositories;

import cinema.Models.auditorium;
import cinema.Models.seat;

import java.util.Optional;

public interface AuditoriumRepository extends CrudRepository<auditorium, Integer> {
    Optional<auditorium> findReservedSeats(int row, int seats);
    Optional<auditorium> findPaidSeats(int row, int seats);
    Optional<auditorium> findFreeSeats(int row, int seats);
}
