package com.ey.moviemanagement;

import com.ey.moviemanagement.controller.MovieController;
import com.ey.moviemanagement.model.Movie;
import com.ey.moviemanagement.repository.MovieRepository;
import com.ey.moviemanagement.service.MovieService;
import com.ey.moviemanagement.service.impl.MovieServiceImpl;
import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class MovieServiceTest {

    @Mock
    MovieRepository movieRepository;

    @InjectMocks
    MovieServiceImpl movieService;


    @Test
    public void testCreateMovie() {

        Movie movie = new Movie();

        movie.setTitle("Test Movie");
        movie.setGenre("Test Genre");
        movie.setTitle("ABC");
        movie.setId(1L);


        Mockito.when(this.movieRepository.save(Mockito.any(Movie.class))).thenReturn(movie);

        Movie movies = movieService.createMovie(movie);


    //   ResponseEntity<Movie> response =  new ResponseEntity<>(movies, HttpStatus.CREATED);

        Assert.assertEquals(movies, movie);

   //     Assert.assertEquals(movie, response.getBody());

    }


    @Test
    public void testGetMovieWithHighestRating() {

        Movie movie = new Movie();

        movie.setTitle("Test Movie");
        movie.setGenre("Test Genre");
        movie.setTitle("ABC");
        movie.setId(1L);

        Optional<Movie> mo = Optional.of(movie);


        Mockito.when(this.movieRepository.findMovieWithHighestRating()).thenReturn(mo);

        Optional<Movie> movies = movieService.getMovieWithHighestRating();


        //   ResponseEntity<Movie> response =  new ResponseEntity<>(movies, HttpStatus.CREATED);

        Assert.assertEquals(movies, mo);

        //     Assert.assertEquals(movie, response.getBody());

    }
    @Test
    public void testGetMovieWithLowestRating() {

        Movie movie = new Movie();

        movie.setTitle("Test Movie");
        movie.setGenre("Test Genre");
        movie.setTitle("ABC");
        movie.setId(1L);

        Optional<Movie> mo = Optional.of(movie);


        Mockito.when(this.movieRepository.findMovieWithLowestRating()).thenReturn(mo);

        Optional<Movie> movies = movieService.getMovieWithLowestRating();


        Assert.assertEquals(movies, mo);



    }
    @Test
    public void testGetMovieWithMostReviews() {

        Movie movie = new Movie();

        movie.setTitle("Test Movie");
        movie.setGenre("Test Genre");
        movie.setTitle("ABC");
        movie.setId(1L);

        Optional<Movie> mo = Optional.of(movie);


        Mockito.when(this.movieRepository.findMovieWithMostReviews()).thenReturn(mo);

        Optional<Movie> movies = movieService.getMovieWithMostReviews();


        Assert.assertEquals(movies, mo);



    }




}
