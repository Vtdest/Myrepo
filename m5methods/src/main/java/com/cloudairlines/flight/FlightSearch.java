package com.cloudairlines.flight;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FlightSearch {

    private FlightStore flightStore;

    public FlightSearch(FlightStore store){
        this.flightStore = Objects.requireNonNull(store);
    }

    public static FlightSearch newSearch() {
        return new FlightSearch(new FlightStoreImpl());
    }

    public List<Flight> search(SearchRequest request){

        if(request == null) {
            throw new IllegalArgumentException("Request cannot be null");
        }

        List<Flight> availableFlights = flightStore.getFlights();

        String from = request.getFrom();
        String to = request.getTo();
        LocalDate date = request.getDate();


        // we'll implement the search later
        return availableFlights;
    }
}
