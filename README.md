# DSList Backend

This repository contains the backend service for DSList, an application for organizing video games into ranked lists. It is built with Java and the Spring Boot framework, providing a RESTful API to manage games and game lists.

## Features

*   Retrieve a list of all games with minimal details.
*   Fetch comprehensive details for a specific game by its ID.
*   View all available game lists (e.g., "Aventura e RPG", "Plataforma").
*   Get all games belonging to a particular list, ordered by their rank.
*   Reorder games within a list by moving them from a source to a destination position.

## Technologies Used

*   **Java 21**
*   **Spring Boot 3**
*   **Spring Web** (for RESTful APIs)
*   **Spring Data JPA** (for data persistence)
*   **Maven** (for dependency management and build)
*   **PostgreSQL** (for development and production database)
*   **H2 Database** (for the test profile)

## API Endpoints

The following endpoints are available:

### Games

*   **GET `/games`**
    *   Description: Retrieves a list of all games.
    *   Response: `200 OK`
    ```json
    [
        {
            "id": 1,
            "title": "Mass Effect Trilogy",
            "year": 2012,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
            "shortDescription": "Lorem ipsum dolor sit amet..."
        }
    ]
    ```

*   **GET `/games/{id}`**
    *   Description: Retrieves the full details for a single game by its ID.
    *   Response: `200 OK`
    ```json
    {
        "id": 1,
        "title": "Mass Effect Trilogy",
        "year": 2012,
        "genre": "Role-playing (RPG), Shooter",
        "platforms": "XBox, Playstation, PC",
        "score": 4.8,
        "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
        "shortDescription": "Lorem ipsum dolor sit amet...",
        "longDescription": "Lorem ipsum dolor sit amet..."
    }
    ```

### Game Lists

*   **GET `/lists`**
    *   Description: Retrieves all game lists.
    *   Response: `200 OK`
    ```json
    [
        {
            "id": 1,
            "name": "Aventura e RPG"
        },
        {
            "id": 2,
            "name": "Plataforma"
        }
    ]
    ```

*   **GET `/lists/{listId}/games`**
    *   Description: Retrieves all games belonging to a specific list, ordered by position.
    *   Response: `200 OK`
    ```json
    [
        {
            "id": 1,
            "title": "Mass Effect Trilogy",
            "year": 2012,
            "imgUrl": "https://raw.githubusercontent.com/devsuperior/java-spring-dslist/main/resources/1.png",
            "shortDescription": "Lorem ipsum dolor sit amet..."
        }
    ]
    ```

*   **POST `/lists/{listId}/replacement`**
    *   Description: Moves a game from a source index to a destination index within a given list.
    *   Request Body:
    ```json
    {
        "sourceIndex": 3,
        "destinationIndex": 1
    }
    ```
    *   Response: `204 No Content`

## Getting Started

### Prerequisites

*   Java JDK 21
*   Maven
*   A running PostgreSQL instance (for the `dev` profile)

### Configuration

The application uses different configuration profiles:

*   **`test` (default):** Uses an in-memory H2 database. No configuration is needed.
*   **`dev`:** Connects to a local PostgreSQL database. You must update your database URL, username, and password in `src/main/resources/application-dev.properties`.
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:5433/dslist
    spring.datasource.username=postgres
    spring.datasource.password=1234567
    ```
*   **`prod`:** Uses environment variables for database credentials (`DB_URL`, `DB_USERNAME`, `DB_PASSWORD`).

When running with the `dev` or `test` profile, the database will be populated with initial data from `src/main/resources/import.sql`.

### Running the Application

1.  **Clone the repository:**
    ```sh
    git clone https://github.com/l-terra/dslist-backend.git
    cd dslist-backend
    ```

2.  **Run the application using the Maven wrapper:**

    To run with the default `test` profile (H2 database):
    ```sh
    ./mvnw spring-boot:run
    ```

    To run with the `dev` profile (PostgreSQL):
    ```sh
    ./mvnw spring-boot:run -Dspring-boot.run.profiles=dev
    ```

The application will start on `http://localhost:8080`.

### CORS
By default, CORS is configured to accept requests from `http://localhost:5173` and `http://localhost:3000`. This can be modified via the `cors.origins` property in `application.properties` or by setting the `CORS_ORIGINS` environment variable.
