package net.virtualinfinity.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestSubstringWithoutRepeatingCharactersTest {

    @ParameterizedTest
    @MethodSource
    void lengthOfLongestSubstring(String input, int expected) {
        int actual = new LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring(input);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> lengthOfLongestSubstring() {
        return Stream.of(
                Arguments.arguments("abcabcbb", 3),
                Arguments.arguments("bbbbbbbb", 1),
                Arguments.arguments("pwwkew", 3)
        );
    }
}