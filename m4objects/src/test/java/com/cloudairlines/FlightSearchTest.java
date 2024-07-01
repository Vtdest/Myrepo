package com.cloudairlines;

import org.junit.jupiter.api.Test;

import java.util.List;

public class FlightSearchTest {

    @Test
    public void quickFlightSearchTest() {
        var search = new FlightSearchService();
        List<Flight> flights = search.search("London", "Paris", "2022-07-22");
        // assert things
    }

    @Test
    public void quickFlightSearchTest2() {
        var search = new FlightSearchService(new TestFlightImpl());
        List<Flight> flights = search.search("London", "Paris", "2022-07-22");
        // assert things
    }

    private class TestFlightImpl implements FlightStore {


        @Override
        public List<Flight> getFlights() {
            return List.of(
                    new Flight("London", "New York", "2022-10-15"));
        }
    }
}
