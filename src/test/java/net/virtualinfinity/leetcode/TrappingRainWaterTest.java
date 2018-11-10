package net.virtualinfinity.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class TrappingRainWaterTest {

    @ParameterizedTest
    @MethodSource
    void trap(int[] height, int expected) {
        int trap = new TrappingRainWater().trap(height);
        assertEquals(expected, trap);

    }

    private static Stream<Arguments> trap() {
        return Stream.of(
                arguments(heights(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1), 6)
        );
    }

    private static int[] heights(int... height) {
        return height;
    }


}