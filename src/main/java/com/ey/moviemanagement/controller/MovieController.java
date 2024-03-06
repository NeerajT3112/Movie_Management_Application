package com.ey.moviemanagement.controller;

import com.ey.moviemanagement.model.Movie;
import com.ey.moviemanagement.service.MovieService;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/movies")
@Tag(
        name = "CRUD REST APIs for Movie Management Application",
        description = "Endpoints for managing movie Management details"
)
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/createMovie")
    public ResponseEntity<Movie> createMovie(@Validated @RequestBody Movie movie) {
        Movie savedMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(savedMovie, HttpStatus.CREATED);
    }

    @GetMapping
    public Page<Movie> getMoviesWithSorting(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortProperty,
            @RequestParam(defaultValue = "ASC") Sort.Direction direction) {
        return movieService.getAllMoviesWithSorting(page, size, sortProperty, direction);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id) {
        Movie movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/highestRating")
    public ResponseEntity<Movie> getMovieWithHighestRating() {
        return movieService.getMovieWithHighestRating()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/lowestRating")
    public ResponseEntity<Movie> getMovieWithLowestRating() {
        return movieService.getMovieWithLowestRating()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/mostReviews")
    public ResponseEntity<Movie> getMovieWithMostReviews() {
        return movieService.getMovieWithMostReviews()
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


}

