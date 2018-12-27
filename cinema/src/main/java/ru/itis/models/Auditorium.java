package ru.itis.models;

import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Auditorium {
    private Long id;
    private String name;

    private Integer seats_id;
    private List<Screening> screeningList;

}
