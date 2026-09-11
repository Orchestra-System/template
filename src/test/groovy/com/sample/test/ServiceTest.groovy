package com.sample.test

import com.sample.HelloJob
import com.sample.service.PersonService
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test

import static io.restassured.RestAssured.given
import static org.hamcrest.Matchers.equalTo;

class ServiceTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "http://127.0.0.1:8080";
    }

    @Test
    void checkPersonService() {
        def person = PersonService.savePerson("Ali")
        Assertions.assertEquals(person.getName(), "Ali")
    }

    @Test
    void checkJob() {
        def job = new HelloJob();
        Assertions.assertThrowsExactly(RuntimeException, job::run)
    }

    @Test
    void checkApi() {
        given()
                .accept(ContentType.JSON)
                .when()
                .pathParam("name", "Mahdi")
                .get("/api/hello/{name}")
                .then()
                .statusCode(200)
                .body("name", equalTo("Mahdi"))
    }
}