package com.cloudairlines.utils;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestDataUtils {
    /**
     * Helpful JavaDoc here
     * @return
     */
    public static Stream<Arguments> getInvalidDates() {
        return Stream.of(
                Arguments.of("2022-07/16"),
                Arguments.of("2022-13-16"),
                Arguments.of("01-01-2024")
        );
    }
}
