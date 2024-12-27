package com.aqatesting.cheks;

import com.aqatesting.payloads.Booking;
import com.aqatesting.payloads.BookingDates;
import com.aqatesting.requests.BookingApi;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;


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
                new Date(2021, Calendar.JANUARY, 1),
                new Date(2021, Calendar.JANUARY, 3)
        );

        Booking plyload = new Booking(
                1,
                "Mark",
                "Winteringham",
                true,
                dates,
                "Breakfast"
        );

        Response response = BookingApi.postBooking(plyload);

        assertEquals(201, response.getStatusCode());
    }
}
