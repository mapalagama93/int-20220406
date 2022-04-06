package com.hasitha.int20220405.integration;

import io.restassured.RestAssured;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class MetricsControllerTest {

    @BeforeAll
    public static void beforeAll() {
        RestAssured.baseURI = "http://localhost:8080";
    }

    @Test
    public void testAnnualizedReturnMetric_FailWith400() {
        Response response = given()
                .queryParam("symbol", "APPL")
                .when()
                .get("/metrics/annualized-return")
                .then()
                .statusCode(400)
                .extract()
                .response();
        response.prettyPrint();
    }

    @Test
    public void testAnnualizedReturnMetric_Success() {
        Response response = given()
                .queryParam("symbol", "AAPL")
                .queryParam("duration", 365)
                .when()
                .get("/metrics/annualized-return")
                .then()
                .statusCode(200)
                .extract()
                .response();
        response.prettyPrint();
    }

}
