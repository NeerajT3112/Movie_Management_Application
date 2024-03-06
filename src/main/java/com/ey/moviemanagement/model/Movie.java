package com.ey.moviemanagement.model;

import jakarta.persistence.*;

import jakarta.validation.constraints.*;
import lombok.Data;


@Data
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title is required")
    @Size(max = 255, message = "Title must not exceed 255 characters")
    private String title;

    @NotBlank(message = "Genre is required")
    @Size(max = 100, message = "Genre must not exceed 100 characters")
    private String genre;

    @NotNull(message = "Release year is required")
    @Min(value = 1888, message = "Release year must be greater than or equal to 1888")
    @Max(value = 2100, message = "Release year must be less than or equal to 2100")
    private Integer releaseYear;

    @NotBlank(message = "Director is required")
    @Size(max = 255, message = "Director must not exceed 255 characters")
    private String director;

    @NotNull(message = "Rating is required")
    @Min(value = 0, message = "Rating must be greater than or equal to 0")
    @Max(value = 10, message = "Rating must be less than or equal to 10")
    private Double rating;

    @NotNull(message = "Review count is required")
    private Integer reviewCount = 0;


}

