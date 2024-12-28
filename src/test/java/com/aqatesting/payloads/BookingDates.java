package com.aqatesting.payloads;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalDate;

public class BookingDates {

    @JsonProperty
    private LocalDate checkin;

    @JsonProperty
    private LocalDate checkout;

    private BookingDates() {}

    public BookingDates(LocalDate checkin, LocalDate checkout) {
        this.checkin = checkin;
        this.checkout = checkout;
    }

    public LocalDate getCheckin() {
        return checkin;
    }

    public LocalDate getCheckout() {
        return checkout;
    }
}