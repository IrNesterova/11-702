package ru.itis.services;

import ru.itis.models.Movie;
import ru.itis.repositories.MovieRepository;

import java.util.List;

public class SearchServiceImpl implements SearchService{
    private MovieRepository movieRepository;
    public SearchServiceImpl(MovieRepository movieRepository){
        this.movieRepository = movieRepository;
    }

    @Override
    public List<Movie> searchByTitle(String title) {
        return movieRepository.findAllByTitleSearch(title);
    }

    @Override
    public List<Movie> searchByDirector(String director) {
        return movieRepository.findAllByDirectorSearch(director);
    }
}
