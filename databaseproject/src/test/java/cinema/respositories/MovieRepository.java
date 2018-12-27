package cinema.respositories;

import cinema.Models.movie;

import java.util.Optional;

public interface MovieRepository extends CrudRepository<movie, Integer> {
    Optional<movie> findByTitle(String title);
    Optional<movie> findbyDirector(String director);
    Optional<movie> findbyActors(String actors);
    Optional<movie> findbyDuration(int duration_min);
}
