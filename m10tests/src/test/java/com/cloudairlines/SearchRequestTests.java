package com.cloudairlines;

import com.cloudairlines.flight.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static com.cloudairlines.airport.AirportStore.*;

public class SearchRequestTests {

    @Test
    @DisplayName("Your description here")
    public void sameCityNotAllowed() {
        Assertions.assertThrows(IllegalArgumentException.class,

                () -> new SearchRequest("London", "London", "2022-07-15")) ;
    }

    @ParameterizedTest
    @CsvSource({
            "    ,New York,2022-10-16",
            "London,    ,2022-10-16"
    })
    public void invalidInputIsRejected(String from, String to, String date) {

            Assertions.assertThrows(NullPointerException.class,

                    () -> new SearchRequest(from, to, date));
    }

    @ParameterizedTest
    @MethodSource("com.cloudairlines.utils.TestDataUtils#getInvalidDates")
    public void searchRejectsInvalidDateFormat(String invalidDate) {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> new SearchRequest("London", "New York", invalidDate));
    }


    @Test
    public void searchReturnsCorrectNumberOfFlights() {
        var request = new SearchRequest("London", "New York", "2022-10-15");
        var flightSearch = new FlightSearch(new TestFlightStore());

        var foundFlights = flightSearch.search(request);

        Assertions.assertEquals(1, foundFlights.size(),
                "Test data contains multiple London to New York flights. " +
                        "The search should've produced exactly one search result given the unique date.");
    }

    private class TestFlightStore implements FlightStore {
        @Override
        public List<Flight> getFlights() {
            return List.of(
                    new Flight(LONDON_GATWICK, NEW_YORK_JFK, "2022-10-15"),
                    new Flight(LONDON_GATWICK, NEW_YORK_JFK, "2022-11-15"),
                    new Flight(LONDON_GATWICK, PARIS_CDG, "2022-11-20")
            );
        }
    }
}
