package ru.itis.models;

import lombok.*;

import java.sql.Timestamp;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Screening implements Comparable<Screening>{
    public Long id_screening;
    public Timestamp screening_start;
    public String id_movie;
    public String auditorium_id;

    @Override
    public int compareTo(Screening o) {
        if (o.getScreening_start().after(screening_start)) return -1;
        else if (o.getScreening_start().before(screening_start)) return 1;
        return 0;
    }
}
