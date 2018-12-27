package ru.itis.models;

import lombok.*;

import java.sql.Time;
import java.sql.Timestamp;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Reservation {
    public Long id;

    public String reservation_contact;
    public boolean reserved;
    public boolean paid;
    public boolean active;

    public Timestamp screening_id_start;
    public String employee_reserved_id_name;
    public String employee_paid_id_name;

    private String reservation_type_id;
    private Seat reservedseat;
}
