package cinema.Forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieForm {
    private String title;
    private String description;
    private String actors;
    private String director;
    private String duration_min;
}
