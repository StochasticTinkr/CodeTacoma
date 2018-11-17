package net.virtualinfinity.leetcode.kthsmallest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    public void kthSmallest(int[][] matrix, int k) {
        int expected = Stream.of(matrix)
                .flatMapToInt(IntStream::of)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(0);

        Assertions.assertEquals(expected, new Solution().kthSmallest(matrix, k));
    }

    public static Stream<Arguments> kthSmallest() {
        return Stream.of(
                arguments(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 4),
                arguments(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 8),
                arguments(new int[][]{
                        {1, 5, 9},
                        {10, 11, 13},
                        {12, 13, 15}
                }, 9),
                arguments(new int[][]{
                        {2, 6, 6, 7, 10, 14, 18},
                        {6, 11, 14, 14, 15, 20, 23},
                        {11, 11, 17, 21, 25, 30, 30},
                        {11, 12, 20, 25, 25, 35, 37},
                        {16, 16, 20, 29, 34, 35, 39},
                        {16, 18, 22, 33, 37, 37, 40},
                        {17, 23, 26, 36, 38, 41, 42}
                }, 32)
        );
    }


    }