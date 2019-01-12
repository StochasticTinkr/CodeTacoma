package net.virtualinfinity.leetcode.nextpermutation;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    void nextPermutation(int[] input, int[] exectedOutput) {
        new Solution().nextPermutation(input);
        assertArrayEquals(exectedOutput, input, () -> "\n" +
                "Expected: " + toString(exectedOutput) + "\n" +
               "Actual:   " + toString(input));
    }

    private String toString(int[] exectedOutput) {
        return IntStream.of(exectedOutput).mapToObj(String::valueOf).collect(Collectors.joining(", "));
    }

    private static List<Arguments> nextPermutation() {
        int[][] inputs = {
                {1, 2, 3, 4},
                {1, 2, 4, 3},
                {1, 3, 2, 4},
                {1, 3, 4, 2},
                {1, 4, 2, 3},
                {1, 4, 3, 2},
                {2, 1, 3, 4},
                {2, 1, 4, 3},
                {2, 3, 1, 4},
                {2, 3, 4, 1},
                {2, 4, 1, 3},
                {2, 4, 3, 1},
                {3, 1, 2, 4},
                {3, 1, 4, 2},
                {3, 2, 1, 4},
                {3, 2, 4, 1},
                {3, 4, 1, 2},
                {3, 4, 2, 1},
                {4, 1, 2, 3},
                {4, 1, 3, 2},
                {4, 2, 1, 3},
                {4, 2, 3, 1},
                {4, 3, 1, 2},
                {4, 3, 2, 1},
        };
        List<Arguments> args = new ArrayList<>();
        for (int i = 0; i < inputs.length; ++i) {
            int[] in = Arrays.copyOf(inputs[i], inputs[i].length);
            int[] out = inputs[(i + 1) % inputs.length];
            args.add(Arguments.arguments(in, out));
        }
        return args;
    }
}