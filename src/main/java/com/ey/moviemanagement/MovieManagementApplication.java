package com.ey.moviemanagement;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Movie Management Spring Boot REST API Application",
				description = "The Movie Management System is a web application developed using Spring Boot and Java that facilitates CRUD operations for managing movie records via RESTful services. The application allows users to add, fetch, update, and delete movie records, as well as retrieve movies with the highest/lowest rating and most reviews.",
				version = "v1"
		)
)
public class MovieManagementApplication {

	public static void main(String[] args) {

		SpringApplication.run(MovieManagementApplication.class, args);
	}

}
