package com.aqatesting.cheks;

import com.aqatesting.payloads.Booking;
import com.aqatesting.payloads.BookingDates;
import com.aqatesting.payloads.BookingResponse;
import com.aqatesting.requests.BookingApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class BookingApiIT {

    @Test
    public void getBookingSummaryShouldReturn200() {
        Response response = BookingApi.getBookingSummary();

        assertEquals(200, response.getStatusCode());
    }

    @Test
    public void getBookingSummaryNegativeSC233ShouldReturn200() {
        Response response = BookingApi.getBookingSummary();

        assertNotEquals(233, response.getStatusCode());
    }

    @Test
    public void postBookingReturn201() {
        BookingDates dates = new BookingDates(
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 1, 3)
        );

        Booking plyload = new Booking(
                17,
                "Mark",
                "Winteringham",
                true,
                dates,
                "Breakfast"
        );

        Response response = BookingApi.postBooking(plyload);

        assertEquals(201, response.getStatusCode());
    }

    @Test
    public void deleteBookingReturns202() {
        BookingDates dates = new BookingDates(
                LocalDate.of(2021, 1, 1),
                LocalDate.of(2021, 1, 3)
        );

        Booking plyload = new Booking(
                1,
                "Mark",
                "Winteringham",
                true,
                dates,
                "Breakfast"
        );

        Response bookingResponse = BookingApi.postBooking(plyload);
        BookingResponse createBookingResponse = bookingResponse.as(BookingResponse.class);
    }
}