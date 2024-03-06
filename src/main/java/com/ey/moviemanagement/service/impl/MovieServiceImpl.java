package com.ey.moviemanagement.service.impl;

import com.ey.moviemanagement.exception.MovieNotFoundException;
import com.ey.moviemanagement.model.Movie;
import com.ey.moviemanagement.repository.MovieRepository;
import com.ey.moviemanagement.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Page<Movie> getAllMoviesWithSorting(int page, int size, String sortProperty, Sort.Direction direction) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(direction, sortProperty));
        return movieRepository.findAll(pageable);
    }

    // Create a new movie
    @Override
    public Movie createMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    // Fetch a single movie by ID
    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

    // Delete a movie by ID
    @Override
    public void deleteMovieById(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new MovieNotFoundException(id);
        }
        movieRepository.deleteById(id);
    }

    // Find the movie with the highest rating
    @Override
    public Optional<Movie> getMovieWithHighestRating() {
        return movieRepository.findMovieWithHighestRating();
    }

    // Find the movie with the lowest rating
    @Override
    public Optional<Movie> getMovieWithLowestRating() {
        return movieRepository.findMovieWithLowestRating();
    }

    // Find the movie with the most reviews
    @Override
    public Optional<Movie> getMovieWithMostReviews() {
        return movieRepository.findMovieWithMostReviews();
    }

	@Override
	public Object getAllMovies() {
		// TODO Auto-generated method stub
		return null;
	}

}
