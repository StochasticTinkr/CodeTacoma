package net.virtualinfinity.leetcode.arithmeticslices;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    public void testSolution(int[] input, int expected) {
        assertEquals(expected, new Solution().numberOfArithmeticSlices(input));
    }

    private static Stream<Arguments> testSolution() {
        return Stream.of(
                arguments(input(1,2,3,4), 3),
                arguments(input(1,2,3), 1),
                arguments(input(1,2,2), 0),
                arguments(input(1,2), 0),
                arguments(input(1), 0),
                arguments(input(), 0),
                arguments(input(1,2,3,5,6,7), 2),
                arguments(input(1,2,3,5,7,9), 4)

        );
    }

    public static int[] input(int ... v) {
        return v;
    }


}