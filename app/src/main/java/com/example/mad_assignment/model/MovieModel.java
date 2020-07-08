package com.example.mad_assignment.model;

import java.util.List;

public interface MovieModel {
    List<MovieImpl> getMovieList();

    MovieImpl getMovieByID(String id);

    void removeMovieByID(String id);

    void addMovie(MovieImpl movieImpl);

    int getNextMovieID();

    void saveNewDetail(String id, MovieImpl movieImpl);
}
