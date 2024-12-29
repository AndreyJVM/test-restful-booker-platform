package com.aqatesting.requests;

import com.aqatesting.payloads.Auth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthApi extends BaseApi{

    private static final String API_URL = BASE_API_URL + "3004/auth/";

    public static Response postAuth(Auth payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(API_URL + "login");
    }
}