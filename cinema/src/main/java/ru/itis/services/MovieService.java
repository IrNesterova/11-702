package ru.itis.services;

import ru.itis.forms.movieForm;
import ru.itis.models.Movie;

import java.util.List;

public interface MovieService {
    void addMovie(movieForm movieForm);
    void deleteMovie(Long id);
    void editMovie(Movie movie);
    public List<Movie> getMovie();
    public Movie getMovieById(Long id);
}
