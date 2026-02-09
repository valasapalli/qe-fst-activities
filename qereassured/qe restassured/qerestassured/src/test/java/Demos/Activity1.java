package Demos;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class Activity1 {
    
    String baseURL = "https://petstore.swagger.io/v2";
    // Using a long to store the ID for use across multiple tests
    long petId = 756999; 

    @Test(priority = 1)
    public void addnewpet() {
        String reqBody = """
                {
                    "id": 756999,
                    "name": "piffy",
                    "status": "available"
                }
                """;

        Response response = given()
                .contentType(ContentType.JSON)
                .body(reqBody)
            .when()
                .post(baseURL + "/pet");

        System.out.println("POST Response:");
        System.out.println(response.asPrettyString());
        response.then().statusCode(200);
    }

    @Test(priority = 2)
    public void getpet() {
        Response response = given()
                .contentType(ContentType.JSON)
            .when()
                .get(baseURL + "/pet/" + petId);

        System.out.println("GET Response:");
        System.out.println(response.asPrettyString());
        response.then().statusCode(200)
                .body("name", equalTo("piffy"));
    }

    @Test(priority = 3)
    public void deletepet() {
        Response response = given()
                .contentType(ContentType.JSON)
            .when()
                .delete(baseURL + "/pet/" + petId);

        System.out.println("DELETE Response:");
        System.out.println(response.asPrettyString());
        response.then().statusCode(200);
    }
}