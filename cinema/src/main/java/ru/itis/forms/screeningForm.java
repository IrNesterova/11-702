package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class screeningForm {
    public Long id_screening;
    public Long id_movie;
    public Long auditorium_id;
    public Timestamp screening_start;
}
