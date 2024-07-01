package com.cloudairlines;

import com.cloudairlines.flight.Flight;
import com.cloudairlines.flight.FlightStoreImpl;
import com.cloudairlines.passenger.PassengerSearch;
import com.cloudairlines.passenger.SeatClass;

import static com.cloudairlines.passenger.SeatClass.*;

public class MainFlagArgument {

    public static void main(String[] args) {

        PassengerSearch paxSearch = new PassengerSearch();
        Flight flight = new FlightStoreImpl().getFlights().get(0);

        System.out.println("====== Economy ======");
        paxSearch
                .findPassengersBySeatClass(flight, ECONOMY)
                .forEach(System.out::println);

        System.out.println("====== Non-Economy ======");
        paxSearch
                .findPassengersBySeatClass(flight, BUSINESS)
                .forEach(System.out::println);
    }
}
