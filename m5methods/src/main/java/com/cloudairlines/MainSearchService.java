package com.cloudairlines;


import com.cloudairlines.flight.Flight;
import com.cloudairlines.flight.FlightSearch;
import com.cloudairlines.flight.SearchRequest;

import java.util.List;

public class MainSearchService {

    public static void main(String[] args) {

        String from = args[0];
        String to = args[1];
        String date = args[2];

        var request = new SearchRequest(from, to, date);
        var request2 = new SearchRequest(args); // alternative

        var searchService = FlightSearch.newSearch();

        List<Flight> foundFlights = searchService.search(request);

    }
}
