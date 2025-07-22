import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class WeatherAPI {
    @Test
    public void createWeatherStation() {
        RestAssured.baseURI = "http://api.openweathermap.org";
        String basePath = "/data/3.0/stations";
        String apiKey = "40d6f691559d1fb400a4f78161aecc02";

        String payload = "{\n" +
                "  \"external_id\": \"6875f4c4cbd4230001cc03fc\",\n" +
                "  \"name\": \"SQ Test Station\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response response = given()
                .basePath(basePath)
                .queryParam("appid", apiKey)
                .header("Content-Type", "application/json")
                .body(payload)
                .post();

        System.out.println("Status Code: " + response.getStatusCode());
        // Print response body line by line
        String responseBody = response.getBody().asString();
        for (String line : responseBody.split(",")) {
            System.out.println(line.trim());
        }
    }

    @Test
    public void getWeatherStation() {
        // Ensure createWeatherStation() is run first to create the station before calling this method.
        RestAssured.baseURI = "http://api.openweathermap.org";
        String basePath = "/data/3.0/stations/6875f4c4cbd4230001cc03fc";
        String apiKey = "40d6f691559d1fb400a4f78161aecc02";

        Response response = given()
                .basePath(basePath)
                .queryParam("appid", apiKey)
                .header("Content-Type", "application/json")
                .get();

        System.out.println("Status Code: " + response.getStatusCode());
        // Print response body line by line
        String responseBody = response.getBody().asString();
        for (String line : responseBody.split(",")) {
            System.out.println(line.trim());
        }
    }

    @Test
    public void getAllStations() {
        RestAssured.baseURI = "http://api.openweathermap.org";
        String basePath = "/data/3.0/stations";
        String apiKey = "40d6f691559d1fb400a4f78161aecc02";

        Response response = given()
                .basePath(basePath)
                .queryParam("appid", apiKey)
                .get();

        System.out.println("Status Code: " + response.getStatusCode());
        // Print response body line by line
        String responseBody = response.getBody().asString();
        for (String line : responseBody.split(",")) {
            System.out.println(line.trim());
        }
    }

    @Test
    public void updateWeatherStation() {
        // Ensure createWeatherStation() is run first to create the station before calling this method.
        RestAssured.baseURI = "http://api.openweathermap.org";
        String basePath = "/data/3.0/stations/6875f4c4cbd4230001cc03fc";
        String apiKey = "40d6f691559d1fb400a4f78161aecc02";

        String payload = "{\n" +
                "  \"external_id\": \"6875f4c4cbd4230001cc03fc\",\n" +
                "  \"name\": \"Bluey Test Station\",\n" +
                "  \"latitude\": 37.76,\n" +
                "  \"longitude\": -122.43,\n" +
                "  \"altitude\": 150\n" +
                "}";

        Response response = given()
                .basePath(basePath)
                .queryParam("appid", apiKey)
                .header("Content-Type", "application/json")
                .body(payload)
                .put();


        System.out.println("Status Code: " + response.getStatusCode());
        // Print response body line by line
        String responseBody = response.getBody().asString();
        for (String line : responseBody.split(",")) {
            System.out.println(line.trim());
        }
    }

    @Test
    public void deleteWeatherStation() {
        RestAssured.baseURI = "http://api.openweathermap.org";
        String basePath = "/data/3.0/stations/6876521bcbd4230001cc043a";
        String apiKey = "40d6f691559d1fb400a4f78161aecc02";

        String payload = "{\n" +
                "    \"id\": \"6876521bcbd4230001cc043a\",\n" +
                "    \"created_at\": \"2025-07-15T12:39:53.77Z\",\n" +
                "    \"updated_at\": \"2025-07-15T12:39:53.77Z\",\n" +
                "    \"external_id\": \"SF_TEST001\",\n" +
                "    \"name\": \"San Francisco Test Station\",\n" +
                "    \"longitude\": -122.43,\n" +
                "    \"latitude\": 37.76,\n" +
                "    \"altitude\": 150,\n" +
                "    \"rank\": 10\n" +
                "}";

        Response response = given()
                .basePath(basePath)
                .queryParam("appid", apiKey)
                .header("Content-Type", "application/json")
                .body(payload)
                .delete();

        System.out.println("Status Code: " + response.getStatusCode());
        // Print response body line by line
        String responseBody = response.getBody().asString();
        System.out.println("Station with ID 68764c19cbd4230001cc0438 successfully deleted.");
        for (String line : responseBody.split(",")) {
            System.out.println(line.trim());
        }
    }

    @Test
    public void createWeatherStationNegative() {
        RestAssured.baseURI = "http://api.openweathermap.org";
        String basePath = "/data/3.0/stations";
        String apiKey = "40d6f691559d1fb400a4f78161aecc02";

        // Intentionally missing required fields for negative test
        String payload = "{\n" +
                "  \"external_id\": \"\",\n" + // Empty external_id
                "  \"name\": \"\",\n" + // Empty name
                "  \"latitude\": null,\n" + // Null latitude
                "  \"longitude\": null,\n" + // Null longitude
                "  \"altitude\": null\n" + // Null altitude
                "}";

        Response response = given()
                .basePath(basePath)
                .queryParam("appid", apiKey)
                .header("Content-Type", "application/json")
                .body(payload)
                .post();

        System.out.println("Status Code: " + response.getStatusCode());
        String responseBody = response.getBody().asString();
        System.out.println("Negative scenario response:");
        for (String line : responseBody.split(",")) {
            System.out.println(line.trim());
        }
    }
}