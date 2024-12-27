package com.aqatesting.requests;

import com.aqatesting.payloads.Booking;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

public class BookingApi {
    private static final String apiUrl = "http://localhost:3000/booking/";

    public static Response getBookingSummary () {
        return given()
                .get(apiUrl + "summary?roomid=1");
    }

    public static Response postBooking(Booking payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(apiUrl);
    }
}
