package net.virtualinfinity.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class LongestIncreasingPathInAMatrixTest {

    @ParameterizedTest
    @MethodSource
    void longestIncreasingPath(int[][] matrix, int expected) {
        int actual = new LongestIncreasingPathInAMatrix().longestIncreasingPath(matrix);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> longestIncreasingPath() {
        return Stream.of(
                arguments(new int[][]{{}}, 0),
                arguments(new int[][]{
                        {9, 9, 4},
                        {6, 6, 8},
                        {2, 1, 1}
                }, 4),
                arguments(new int[][]{
                        {3, 4, 5},
                        {3, 2, 6},
                        {2, 2, 1}
                }, 4)
        );
    }
}