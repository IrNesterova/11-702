package cinema.Models;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
@ToString
public class reservation {
    public Long id;

    public String reservation_contact;
    public boolean reserved;
    public boolean paid;
    public boolean active;

    private reservation_type reservation_type;
    private seat reservedseat;
}
