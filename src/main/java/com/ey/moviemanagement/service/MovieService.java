package com.ey.moviemanagement.service;

import com.ey.moviemanagement.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

public interface MovieService {

    Page<Movie> getAllMoviesWithSorting(int page, int size, String sortProperty, Sort.Direction direction);

    // Create a new movie
    Movie createMovie(Movie movie);

    // Fetch a single movie by ID
    Movie getMovieById(Long id);

    // Delete a movie by ID
    void deleteMovieById(Long id);

    // Find the movie with the highest rating
    Optional<Movie> getMovieWithHighestRating();

    // Find the movie with the lowest rating
    Optional<Movie> getMovieWithLowestRating();

    // Find the movie with the most reviews
    Optional<Movie> getMovieWithMostReviews();

	Object getAllMovies();
}
