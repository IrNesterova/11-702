package ru.itis.repositories;


import ru.itis.models.Reservation_type;

public interface ReserationTypeRep extends CrudRepository<Reservation_type> {
    public void getReservationType(Long id);
}
