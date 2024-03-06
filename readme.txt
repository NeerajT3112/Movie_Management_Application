#Read ME File
# Movie Management System

## Description
The Movie Management System is a web application developed using Spring Boot and Java that facilitates CRUD operations for managing movie records via RESTful services. The application allows users to add, fetch, update, and delete movie records, as well as retrieve movies with the highest/lowest rating and most reviews.

## Features
- Create Movie: Add new movie records to the system by providing details such as title, genre, release year, director, and ratings.
- Fetch Movies: Retrieve all movies available in the database.
- Fetch Movie by ID: Fetch a specific movie record based on its unique identifier (ID).
- Delete Movie: Delete a movie record from the system using its ID.
- Get Movie with Highest Rating: Identify and retrieve the movie with the highest rating among all available movies.
- Get Movie with Lowest Rating: Identify and retrieve the movie with the lowest rating among all available movies.
- Get Movie with Most Reviews: Fetch the movie with the highest number of reviews.

## Technologies Used
- Spring Boot
- Java
- Mysql Database
- Maven

## Setup Instructions
1. Clone the repository:



2. Navigate to the project directory:



3. Build the project using Maven:



4. Configure the database connection in the `application.properties` file located in `src/main/resources`:



Replace `your_username` and `your_password` with your Oracle database credentials.

5. Run the application:



6. Access the application at `http://localhost:8080`.

## API Documentation
- The API endpoints are documented using Swagger. You can access the Swagger UI at `http://localhost:8080/swagger-ui.html` after running the application.

## Testing
- Unit tests covering all functionalities are included in the `src/test` directory. You can run the tests using Maven:

## Running Platform
- I have run the Api's with Postman.