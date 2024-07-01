package com.cloudairlines.flight;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class SearchRequest {

    private String from;
    private String to;
    private LocalDate date;

    public SearchRequest(String[] args) {
        this(args[0], args[1], args[2]);
    }

    public SearchRequest(String from, String to, String date) {
        this.from = Objects.requireNonNull(from);
        this.to = Objects.requireNonNull(to);
        this.date = parseDate(date);
    }

    private LocalDate parseDate(String date) {
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public LocalDate getDate() {
        return date;
    }
}
