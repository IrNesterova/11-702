package cinema.Models;

import lombok.*;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class reservation_type {
    private Long id;

    private String reservation_type;
}
