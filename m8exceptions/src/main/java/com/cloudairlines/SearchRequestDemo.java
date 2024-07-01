package com.cloudairlines;

import java.time.LocalDate;

public class SearchRequestDemo {

    public static void main(String[] args) {

        String[] searchInputs = {"From", "To", "30-05-2023"};

        var request = new SearchRequest(searchInputs);

    }
}
