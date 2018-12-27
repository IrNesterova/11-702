package ru.itis.repositories;

import ru.itis.models.Auditorium;

import java.util.Optional;

public interface AuditoriumRepository extends CrudRepository<Auditorium>{
    Optional<Auditorium> findFreeSeats();
}
