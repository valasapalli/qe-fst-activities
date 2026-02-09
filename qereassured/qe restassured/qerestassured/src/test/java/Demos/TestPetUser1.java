package Demos;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

import java.io.FileInputStream;
import java.io.IOException;

public class TestPetUser1 {

    private RequestSpecification requestSpec;
    private ResponseSpecification responseSpec;

    @BeforeClass
    public void setup() {
        requestSpec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri("https://petstore.swagger.io/v2/user")
            .build();

        responseSpec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
    }

    @Test(priority = 0)
    public void createUser() throws IOException {
        FileInputStream input = new FileInputStream("src/test/resources/input.json");

        Response response = given().spec(requestSpec)
        .body(input).when().post();

        response.prettyPrint();

        response.then().spec(responseSpec);
    }

    @Test (priority = 1)
    public void getUser() {
        Response response = given().spec(requestSpec)
        .pathParam("username", "Deeps0")
        .when().get("/{username}");

        response.prettyPrint();

        response.then().spec(responseSpec);
    }

    @Test (priority = 2)
    public void deleteUser() {
        Response response = given().spec(requestSpec)
        .pathParam("username", "abhiram")
        .when().delete("/{username}");

        response = given().spec(requestSpec)
        .pathParam("username", "abhiram")
        .when().get("/{username}");

        response.then().statusCode(404);
    }

}