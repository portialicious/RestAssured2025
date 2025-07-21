# RestAssured2025 Project

## Overview
This project demonstrates API testing using RestAssured in Java. It includes sample tests for interacting with the OpenWeatherMap API, such as creating weather stations, retrieving a specific station, and listing all stations.

## Prerequisites
- Java 8 or higher
- Maven
- Internet connection (for API calls)

## Setup
1. Clone the repository or copy the project files to your local machine.
2. Ensure you have Maven installed. You can check by running `mvn -v` in your terminal.
3. Install dependencies by running:
   ```
   mvn clean install
   ```

## Project Structure
- `src/main/java/org/example/Main.java`: Main entry point (if needed).
- `src/test/java/WeatherAPI.java`: Contains API test cases using RestAssured.
- `pom.xml`: Maven configuration file.

## How to Run Tests
You can run the tests using Maven:
```
mvn test
```

## API Endpoints Used
- **Create Weather Station**: `POST /data/3.0/stations`
- **Get Weather Station**: `GET /data/3.0/stations/{stationId}`
- **Get All Stations**: `GET /data/3.0/stations`

## Notes
- Update the API key in `WeatherAPI.java` with your own OpenWeatherMap API key if needed.
- Replace station IDs in test methods with valid IDs as required.

## License
This project is for educational purposes.

