package org.petstore.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;
import org.petstore.data.Specifications;
import static io.restassured.RestAssured.given;
import static org.petstore.data.Endpoints.URL;
import static org.petstore.data.Endpoints.post_user;

import org.petstore.data.UserData;
import org.petstore.responseData.UserCreated;

public class PetstoreTest {

    @Test
    public void createUser(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        UserData user = new UserData("user123456", "Dmitry", "Petrov", "excoofy@mailto.plus", "123456zxcvbn", "+3574891234");

        UserCreated userCreated = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post(post_user)
                .then().log().all()
                .extract().body().jsonPath().getObject("", UserCreated.class);
    }
}
