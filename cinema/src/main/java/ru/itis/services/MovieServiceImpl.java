package ru.itis.services;

import ru.itis.forms.movieForm;
import ru.itis.models.Movie;
import ru.itis.repositories.MovieRepository;
import ru.itis.repositories.MovieRepositoryJbdcImpl;

import java.util.List;

public class MovieServiceImpl implements MovieService {
    private MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public void addMovie(movieForm movieForm) {
        Movie movie = Movie.builder()
                .id_movie(movieForm.getId_movie())
                .title(movieForm.getTitle())
                .director(movieForm.getDirector())
                .actors(movieForm.getActors())
                .description(movieForm.getDescription())
                .duration_min(movieForm.getDuration_min())
                .build();
        movieRepository.save(movie);
    }

    @Override
    public void deleteMovie(Long id) {
        movieRepository.delete(id);
    }

    @Override
    public void editMovie(Movie movie) {
        movieRepository.update(movie);
    }

    @Override
    public List<Movie> getMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findOne(id);
    }

}
