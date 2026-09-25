package API;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ApiTest extends BaseTest{



    @Test
    public void createToken() {

        Response response =
                given()
                        .spec(requestSpecification)
                        .body("""
                        {
                            "username": "admin",
                            "password": "password123"
                        }
                        """)
                        .log().all()
                        .when()
                        .post("/auth")
                        .then()
                        .spec(responseSpecification)
                        .log().all()
                        .extract()
                        .response();

        System.out.println("Response:");
        System.out.println(response.asPrettyString());

        String token = response.jsonPath().getString("token");

        System.out.println("Token: " + token);
    }
    @Test
    public void getBooking() {
        Response response =given()
                .spec(requestSpecification)
                .when()
                .get("/booking")
                .then()
                .spec(responseSpecification)
                .log().all()
                .extract()
                .response();

    }
    @Test
    public void getBookingById() {

        given()
                .spec(requestSpecification)
                .pathParam("id", 1)
                .when()
                .get("/booking/{id}")
                .then()
                .log().all();
    }

}
