package com.ey.moviemanagement.repository;

import com.ey.moviemanagement.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    Page<Movie> findAll(Pageable pageable);

    // Custom query to fetch the movie with the highest rating
    @Query("SELECT m FROM Movie m WHERE m.rating = (SELECT MAX(m2.rating) FROM Movie m2)")
    Optional<Movie> findMovieWithHighestRating();

    // Custom query to fetch the movie with the lowest rating
    @Query("SELECT m FROM Movie m WHERE m.rating = (SELECT MIN(m2.rating) FROM Movie m2)")
    Optional<Movie> findMovieWithLowestRating();

    // Custom query to fetch the movie with the most reviews
    @Query("SELECT m FROM Movie m WHERE m.reviewCount = (SELECT MAX(m2.reviewCount) FROM Movie m2)")
    Optional<Movie> findMovieWithMostReviews();

}
