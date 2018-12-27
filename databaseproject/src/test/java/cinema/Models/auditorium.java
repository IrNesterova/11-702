package cinema.Models;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class auditorium {
    private Long id;
    private String name;

    private List<seat> seats_id;
    private List<screening> screeningList;
}
