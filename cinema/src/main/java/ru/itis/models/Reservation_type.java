package ru.itis.models;

import lombok.*;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Reservation_type {
    private Long id;

    private String reservation_type;
}
