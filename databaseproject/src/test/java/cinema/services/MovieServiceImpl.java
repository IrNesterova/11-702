package cinema.services;

import cinema.Forms.MovieForm;
import cinema.Models.movie;
import cinema.respositories.MovieRepository;
import cinema.respositories.MovieRepositoryJbdcImpl;
import lombok.SneakyThrows;

public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public void Register(MovieForm movieForm) {
        movie Movie = movie.builder()
                .title(movieForm.getTitle())
                .description(movieForm.getDescription())
                .actors(movieForm.getActors())
                .duration_min(movieForm.getDuration_min())
                .director(movieForm.getDirector())
                .build();
        movieRepository.create(Movie);
    }
}
