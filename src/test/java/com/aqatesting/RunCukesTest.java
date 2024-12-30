package com.aqatesting;


import com.aqatesting.payloads.Booking;
import com.aqatesting.payloads.BookingDates;
import com.aqatesting.payloads.Total;
import com.aqatesting.requests.BookingApi;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.restassured.response.Response;
import org.junit.runner.RunWith;

import java.time.LocalDate;

import static org.junit.Assert.assertEquals;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources"}
)
public class RunCukesTest {

    private Response totalResponse;

    @Given("I have multiple bookings")
    public void i_have_multiple_bookings() {
        BookingDates dates = new BookingDates(
                LocalDate.of(2021, 01, 01),
                LocalDate.of(2021, 03, 01)
        );

        Booking payloadOne = new Booking(
                "Mark",
                "Openwish",
                200,
                true,
                dates,
                "Breakfast"
        );
        Booking payloadTwo = new Booking(
                "Mark",
                "Openwish",
                200,
                true,
                dates,
                "Breakfast"
        );

        BookingApi.postBooking(payloadOne);
        BookingApi.postBooking(payloadTwo);
        throw new io.cucumber.java.PendingException();
    }

    @When("I ask for a reports on my total earnings")
    public void i_ask_for_a_reports_on_my_total_earnings() {
        totalResponse = BookingApi.getTotal();
        throw new io.cucumber.java.PendingException();
    }

    @Then("I will receive a total amount based on all my bookings")
    public void i_will_receive_a_total_amount_based_on_all_my_bookings() {
        int total = totalResponse.as(Total.class).getTotal();

        assertEquals(total, 400);
        throw new io.cucumber.java.PendingException();
    }
}