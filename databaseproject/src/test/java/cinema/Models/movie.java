package cinema.Models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class movie {
    private Long id_movie;
    private String title;
    private String director;
    private String actors;
    private String description;
    private String duration_min;

    private List<auditorium> auditoriumList;
    private List<screening> screeningList;
}
