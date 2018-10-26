package net.virtualinfinity.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class LongestIncreasingSubsequenceTest {

    @ParameterizedTest()
    @MethodSource
    public void lengthOfLIS(int[] input, int expected) {
        int actual = new LongestIncreasingSubsequence().lengthOfLIS(input);
        assertEquals(expected, actual);
    }


    private static Stream<Arguments> lengthOfLIS() {
        return Stream.of(
                arguments(input(10,9,2,5,3,7,101,18), 4)
        );
    }

    private static int[] input(int...input) {
        return input;
    }
}