package Demos;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Activity2 {
    String baseURL = "https://petstore.swagger.io/v2";

    @Test
    public void TestperUser() {
        String username="Deepthi";
        String reqbody = """
                {
                    "id": 833307,
                    "username": "%s",
                    "firstName": "bhavana",
                    "lastName": "golla",
                    "email": "bhavana7bhavs@gmail.com",
                    "password": "Orange",
                    "phone": "1234567890",
                    "userStatus": 0
                }
                """.formatted(username);
        Response responsePost =given().contentType(ContentType.JSON).body(reqbody)
                .when().post(baseURL + "/user").then().statusCode(200)
                .extract().response();
        System.out.println("POST Response:");
        System.out.println(responsePost.asPrettyString());

        Response responseGet = given().contentType(ContentType.JSON).pathParam("username", username)
                .when().get(baseURL + "/user/{username}")
                .then().statusCode(200).extract().response();
        System.out.println("GET Response:");
        System.out.println(responseGet.asPrettyString());

        Response responseDelete =given().contentType(ContentType.JSON).pathParam("username", username)
                .when().delete(baseURL + "/user/{username}")
                .then().statusCode(200).extract().response();
        System.out.println("DELETE Response:");
        System.out.println(responseDelete.asPrettyString());
        given()
            .contentType(ContentType.JSON)
            .pathParam("username", username)
        .when()
            .get(baseURL + "/user/{username}")
        .then()
            .statusCode(404);
    }
}