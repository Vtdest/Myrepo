package com.cloudairlines;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SearchRequestAfter {

    private String from;
    private String to;
    public LocalDate date;


    public SearchRequestAfter(String[] args) {
        // unhelpful message
        if (args.length != 3) {
            throw new IllegalArgumentException("Exactly 3 arguments must be provided in the following order: 'From', 'To', 'Date'. You provided " + args.length + " arguments");
        }
        this.to = isInvalidString(args[0]);
        this.from = isInvalidString(args[1]);
        this.date = parseInputDate(args[2]);

        if (from.equalsIgnoreCase(to)) {
            throw new IllegalArgumentException("'From' and 'To' cannot be the same. You input '" + from + "'");
        }

    }

    private LocalDate validateDate(String stringDate) {
        String date = isInvalidString(stringDate);
        return parseInputDate(date);
    }


    private LocalDate parseInputDate(String departDate) {
        LocalDate date;

        try {
            date = LocalDate.parse(departDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        } catch (DateTimeParseException exception) {
            // or display a user-friendly message on the UI
// 1-            throw exception;
// 2-            throw new IllegalArgumentException("Invalid date format", exception);
            throw new IllegalArgumentException(String.format("Failed to parse input date %s, expected format is yyyy-MM-dd", departDate));
        }
        return date;
    }

    private String isInvalidString(String s) {
        if (s == null || s.trim().isEmpty()) {
            throw new IllegalArgumentException("You have provided the following argument, but it cannot be null or empty:" + s);
        }
        return s;
    }
}
