package net.virtualinfinity.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class FractionAdditionAndSubtractionTest {

    @ParameterizedTest
    @MethodSource
    void fractionAddition(String input, String expected) {
        String actual = new FractionAdditionAndSubtraction().fractionAddition(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> fractionAddition() {
        return Stream.of(
                arguments("-1/2+1/2", "0/1"),
                arguments("-1/2+1/2+1/3", "1/3"),
                arguments("1/3-1/2", "-1/6"),
                arguments("5/3+1/3", "2/1")
        );
    }
}