package com.cloudairlines;

import java.util.List;
import java.util.Objects;

public class FlightSearchService {

    private FlightStore flightStore;

    public FlightSearchService(FlightStore store) {
        this.flightStore = Objects.requireNonNull(store);
    }

    public FlightSearchService(){
        this.flightStore = new FlightStoreImpl();
    }

    public static FlightSearchService newSearch() {
        return new FlightSearchService(new FlightStoreImpl());
    }


    public List<Flight> search(String fromDest, String toDest, String departDate){
        List<Flight> availableFlights = flightStore.getFlights();

        // we'll implement the search later
        return availableFlights;
    }
}
