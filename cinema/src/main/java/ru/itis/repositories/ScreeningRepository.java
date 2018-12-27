package ru.itis.repositories;

import ru.itis.models.Movie;
import ru.itis.models.Screening;

import java.util.List;
import java.util.Optional;

public interface ScreeningRepository extends CrudRepository<Screening>{
    Optional<Screening> findByMovieId(Long movie_id);
    public List<Screening> getMovieTitle(Long movie_id);
}
