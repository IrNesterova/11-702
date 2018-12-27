package ru.itis.services;

import ru.itis.forms.ReservationForm;
import ru.itis.models.Reservation;
import ru.itis.repositories.ReservationRepository;
import ru.itis.repositories.ScreeningRepository;

import java.sql.Timestamp;
import java.util.List;

public class ReservationServiceImpl implements ReservationService{
    private ReservationRepository reservationRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public void reserveSeat(ReservationForm reservationForm) {
        Reservation reservation = Reservation.builder()
                .employee_paid_id_name(reservationForm.getEmployee_paid_id().toString())
                .employee_reserved_id_name(reservationForm.getEmployee_reserved_id().toString())
                .id(reservationForm.getId())
                .paid(reservationForm.getPaid())
                .active(reservationForm.getActive())
                .reservation_type_id(reservationForm.getReservation_type())
                .reservation_contact(reservationForm.getReservation_contact())
                .screening_id_start(Timestamp.valueOf(reservationForm.getScreening_id().toString()))
                .build();
        reservationRepository.save(reservation);
    }

    @Override
    public void editReserved() {

    }

    @Override
    public void deleteReservation(Long id) {
        reservationRepository.delete(id);
    }

    @Override
    public Reservation getReservation(Long id) {
       return reservationRepository.findOne(id);
    }

    @Override
    public List<Reservation> getReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public void isStillActive() {

    }

}
