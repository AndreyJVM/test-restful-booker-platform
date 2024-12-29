package com.aqatesting.requests;

import com.aqatesting.payloads.Booking;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class BookingApi extends BaseApi{
    private static final String API_URL = BASE_API_URL + "3000/booking/";

    public static Response getBookingSummary () {
        return given()
                .get(API_URL + "summary?roomid=1");
    }

    public static Response postBooking(Booking payload) {
        return given()
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post(API_URL);
    }

    public static Response deleteBooking(int id, String tokenValue) {
        return given()
                .header("Cookie", "token=" + tokenValue)
                .delete(API_URL + Integer.toString(id));
    }
}
