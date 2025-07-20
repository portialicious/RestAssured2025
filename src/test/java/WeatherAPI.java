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
                "  \"external_id\": \"SF_TEST001\",\n" +
                "  \"name\": \"Girls in the hood\",\n" +
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
        System.out.println("Response Body: " + response.getBody().asString());
    }

    @Test
    public void getWeatherStation() {
        RestAssured.baseURI = "http://api.openweathermap.org";
        String basePath = "/data/3.0/stations/{stationId}";
        String apiKey = "40d6f691559d1fb400a4f78161aecc02";
        String stationId = "68765554cbd4230001cc0441"; // Replace with actual station ID

        Response response = given()
                .basePath(basePath)
                .pathParam("stationId", stationId)
                .queryParam("appid", apiKey)
                .get();

        System.out.println("Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
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
        System.out.println("Response Body: " + response.getBody().asString());
    }
}