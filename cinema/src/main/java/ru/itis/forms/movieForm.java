package ru.itis.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.net.URL;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class movieForm {
    private Long id_movie;
    private String title;
    private String director;
    private String actors;
    private String description;
    private String duration_min;
    private String ratings;
    private String posteraddress;
}
