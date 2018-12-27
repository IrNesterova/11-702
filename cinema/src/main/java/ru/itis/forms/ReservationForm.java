package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ReservationForm {
    Long id;
    Long screening_id;
    Long employee_reserved_id;
    String reservation_type;
    String reservation_contact;
    Boolean reserved;
    Long employee_paid_id;
    Boolean paid;
    Boolean active;
}
