package cinema.Models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class seat {
    private Long id;

    private Integer row;
    private Integer number;

    private auditorium auditorium_id;
}
