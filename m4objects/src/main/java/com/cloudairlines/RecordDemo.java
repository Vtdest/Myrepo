package com.cloudairlines;


import java.util.Objects;

public class RecordDemo {

    public static void main(String[] args) {

        var flight = new Flight("London", "New York", "2022-08-30");
        System.out.println(flight.from());

    }

    public record Flight(String from, String to, String date) {

        public Flight {
            Objects.requireNonNull(from);
            Objects.requireNonNull(to);
        }
    }
}
