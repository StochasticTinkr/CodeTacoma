package net.virtualinfinity.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    private static final String[][] possibilities = {
            {"a", "b", "c"}, // 2
            {"d", "e", "f"}, // 3
            {"g", "h", "i"}, // 4
            {"j", "k", "l"}, // 5
            {"m", "n", "o"}, // 6
            {"p", "q", "r", "s"}, // 7
            {"t", "u", "v"}, // 8
            {"w", "x", "y", "z"}, // 9
    };

    public List<String> letterCombinations(String digits) {
        return digits.chars()
                .mapToObj(ch -> possibilities[ch - '2'])
                .map(Arrays::asList)
                .reduce(
                        (left, right) ->
                                left.stream()
                                        .flatMap(
                                                leftString -> right.stream()
                                                        .map(rightString -> leftString + rightString)
                                        ).collect(Collectors.toList())
                ).orElseGet(Collections::emptyList);
    }
}
