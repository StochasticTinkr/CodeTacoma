package net.virtualinfinity.leetcode.palindromicsubstrings;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class SolutionTest {

    @ParameterizedTest
    @MethodSource
    void countSubstrings(String input, int expected) {
        int actual = new Solution().countSubstrings(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> countSubstrings() {
        return Stream.of(
                arguments("abc", 3),
                arguments("aaa", 6),
                arguments("aab", 4)
        );
    }


}