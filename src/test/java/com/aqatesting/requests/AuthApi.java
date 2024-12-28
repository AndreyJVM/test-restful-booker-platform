package com.aqatesting.requests;

import com.aqatesting.payloads.Auth;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static com.aqatesting.requests.BaseApi.baseApiUrl;
import static io.restassured.RestAssured.given;

public class AuthApi {

    private static final String apiUrl = baseApiUrl + "3004/auth/";

    public static Response postAuth(Auth payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl + "login");
    }
}