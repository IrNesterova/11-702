package ru.itis.services;

import ru.itis.forms.ReservationForm;
import ru.itis.models.Reservation;
import ru.itis.repositories.CrudRepository;

import java.util.List;

public interface ReservationService{
    void reserveSeat(ReservationForm reservationForm);
    void editReserved();
    void deleteReservation(Long id);
    Reservation getReservation(Long id);
    public List<Reservation> getReservation();
    void isStillActive();
}
