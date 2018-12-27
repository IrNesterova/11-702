package cinema.Models;

import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class Employee {
    private Long id;

    private String username;
    private String hashPassword;

    private List<reservation> reservations;
    private List<movie> movies;

}
