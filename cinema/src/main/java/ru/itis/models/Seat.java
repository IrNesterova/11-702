package ru.itis.models;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Seat {
    private Long id;

    private Integer row;
    private Integer number;

    private String auditorium_id;
}
