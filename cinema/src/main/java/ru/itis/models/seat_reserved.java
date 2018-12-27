package ru.itis.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.itis.repositories.ReservationTypeRepImol;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class seat_reserved {
    public Long id_seat_reserved;
    public Long seat_id;
    public Reservation reservation;
    public Long screening_id;
}
