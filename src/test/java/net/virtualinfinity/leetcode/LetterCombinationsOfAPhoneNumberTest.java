package net.virtualinfinity.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.params.provider.Arguments.arguments;

class LetterCombinationsOfAPhoneNumberTest {

    @ParameterizedTest
    @MethodSource
    void letterCombinations(String input, String...expected) {
        List<String> actual = new LetterCombinationsOfAPhoneNumber().letterCombinations(input);
        Assertions.assertEquals(new HashSet<>(Arrays.asList(expected)), new HashSet<>(actual));

    }

    private static Stream<Arguments> letterCombinations() {
        return Stream.of(
                arguments("23", expected("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf")),
                arguments("", expected())
        );
    }

    private static String[] expected(String...expected) {
        return expected;
    }
}