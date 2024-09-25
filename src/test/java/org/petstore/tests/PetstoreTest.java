package org.petstore.tests;

import io.restassured.http.ContentType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.petstore.data.Specifications;
import static io.restassured.RestAssured.given;
import static org.petstore.data.Endpoints.*;

import org.petstore.data.UserData;
import org.petstore.responseData.UserCreatedUpdated;

public class PetstoreTest {

    @Test
    public void createUser(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        UserData user = new UserData("user1234567", "Dmitry", "Petrov", "excoofy@mailto.plus", "123456zxcvbn", "+3574891234");

        UserCreatedUpdated userCreated = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(user)
                .when()
                .post(post_user)
                .then().log().all()
                .extract().body().jsonPath().getObject("", UserCreatedUpdated.class);
    }

    @Test
    public void getUser(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        String username = "user1234567";

        given()
                .accept(ContentType.JSON)
                .pathParam("username", username)
                .when()
                .get(get_user)
                .then().log().all();
    }

    @Test
    public void updateUser(){
        Specifications.installSpecification(Specifications.requestSpecification(URL), Specifications.responseSpecificationOK200());
        String username = "user1234567";
        UserData user = new UserData( "Petr", "Nikolaev", "excoof@mail.plus",  "+3574891234", "123456.zxcvbn");

        UserCreatedUpdated userUpdated = given()
                .accept(ContentType.JSON)
                .contentType(ContentType.JSON)
                .pathParam("username", username)
                .body(user)
                .when()
                .put(put_user)
                .then().log().all()
                .extract().as(UserCreatedUpdated.class);
    }
}
