package com.ey.moviemanagement;

import com.ey.moviemanagement.controller.MovieController;
import com.ey.moviemanagement.model.Movie;
import com.ey.moviemanagement.repository.MovieRepository;
import com.ey.moviemanagement.service.MovieService;
import com.google.common.base.Verify;
import junit.framework.Assert;
import org.apache.catalina.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class MovieControllerTest {


    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;


    @Test
    public void testCreateMovie() {

        Movie movie = new Movie();

        movie.setTitle("Test Movie");
        movie.setGenre("Test Genre");


        when(movieService.createMovie(Mockito.any(Movie.class))).thenReturn(movie);

        ResponseEntity<Movie> response = movieController.createMovie(movie);

        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());

        Assert.assertEquals(movie, response.getBody());

    }


    @Test
    public void testFetchMovies() {

        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();

        movie.setTitle("Test Movie");
        movie.setGenre("Test Genre");


        ResponseEntity<Movie> response = movieController.getMovieById(8L);


        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());


    }
    /*@Test(expected = RuntimeException.class)
    public void whenGivenId_shouldDeleteMovie_ifFound()
    {

        List<Movie> movies = new ArrayList<>();

        Movie movie = new Movie();

        movie.setTitle("Test Movie");
        movie.setGenre("Test Genre");
        movie.setId(1L);


        when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
       // movieService.deleteMovieById(movie.getId());
        assertThrows(RuntimeException.class,movieRepository.deleteMovieById("111"));
    }*/
}






