package com.cloudairlines;

public class Flight {

    private static final int DEFAULT_CAPACITY = 100;
    private String fromDest;
    private String toDest;
    private String date;
    int seatCapacity;

    public Flight(String fromDest, String toDest, String date) {
        this(fromDest, toDest, date, DEFAULT_CAPACITY);
    }

    public Flight(String fromDest, String toDest, String date, int seatCapacity) {
        // + validation of input
        this.fromDest = fromDest;
        this.toDest = toDest;
        this.date = date;
        this.seatCapacity = seatCapacity;
    }


    public Flight(Airport from, Airport to, String date) {
        this.fromDest = from.getCity();
        // ...
    }



    @Override
    public String toString() {
        return "Flight{" +
                "fromDest='" + fromDest + '\'' +
                ", toDest='" + toDest + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
