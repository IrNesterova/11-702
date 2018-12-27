package ru.itis.repositories;

import ru.itis.models.Reservation;

import java.util.Optional;

public interface ReservationRepository extends CrudRepository<Reservation>{
    Optional<Reservation> findByContact(String contact);
    boolean isActive(Boolean active);
}
