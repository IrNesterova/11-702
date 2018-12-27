package ru.itis.services;

import ru.itis.models.Movie;

import java.util.List;

public interface SearchService {
    List<Movie> searchByTitle(String title);
    List<Movie> searchByDirector(String director);
}
