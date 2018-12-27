package ru.itis.repositories;

import ru.itis.models.Movie;
import ru.itis.models.Screening;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends CrudRepository<Movie>{

    List<Movie> findAllByTitleSearch(String title);
    List<Movie> findAllByDirectorSearch(String director);
    List<Movie> getAllScreening(Long id);
}
