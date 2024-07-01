package com.cloudairlines;

import com.cloudairlines.flight.Flight;
import com.cloudairlines.flight.FlightSimpleStore;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class MainFlightsFromFile {

    public static void main(String[] args) {
        String path = "m5methods/src/main/resources/flights.json";

        String content = readFileBufferedReader(path);

        FlightSimpleStore store = new FlightSimpleStore();

        List<Flight> flights = store.getFlights(content);
        flights.forEach(System.out::println);
    }

    public static String readFileBufferedReader(String path) {
        BufferedReader objReader = null;
        StringBuilder fileContent = new StringBuilder();
        try {
            String strCurrentLine;
            objReader = new BufferedReader(new FileReader(path));
            while ((strCurrentLine = objReader.readLine()) != null) {

                fileContent.append(strCurrentLine);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (objReader != null) {
                try {
                    objReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return fileContent.toString();
    }

    // TODO - move all of the below  to exception handling module
    public static String readFileBufferedReaderSimpler(String pathToFile) {
        try(BufferedReader reader = new BufferedReader(new FileReader(pathToFile))) {
            // while loop > build a string > return
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String readFileWithInputStream(String pathToFile) {

        try (var in = new FileInputStream(pathToFile)) {
            return new String(in.readAllBytes(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static String readSmallFile(String pathToFile) {
        try {
            return Files.readString(Path.of(pathToFile));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }




}
