package ru.itis.models;

import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;

import java.util.List;
@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Movie implements Comparable<Movie>{
    private Long id_movie;
    private String title;
    private String director;
    private String actors;
    private String description;
    private String duration_min;
    private String ratings;
    private String posterAddress;

    private List<Auditorium> auditoriumList;
    private List<Screening> screeningList;
    private List<Movie> movieList;

    @Override
    public int compareTo(Movie o) {
        return (o.id_movie.compareTo(id_movie));
    }
}
