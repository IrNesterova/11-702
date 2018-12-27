package cinema.Models;

import lombok.*;


import java.sql.Timestamp;
@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class screening {
    private Long id;

    private Timestamp screening_start;

    private movie movie_id;
    private auditorium auditorium;

}
