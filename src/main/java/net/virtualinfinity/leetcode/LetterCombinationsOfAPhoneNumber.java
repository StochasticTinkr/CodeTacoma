package net.virtualinfinity.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/
 */
public class LetterCombinationsOfAPhoneNumber {
    private static final List<char[]> possibilities = Arrays.asList(new char[][]{
            {'a', 'b', 'c'}, // 2
            {'d', 'e', 'f'}, // 3
            {'g', 'h', 'i'}, // 4
            {'j', 'k', 'l'}, // 5
            {'m', 'n', 'o'}, // 6
            {'p', 'q', 'r', 's'}, // 7
            {'t', 'u', 'v'}, // 8
            {'w', 'x', 'y', 'z'}, // 9
    });

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return Collections.emptyList();
        }
        int[] idx = new int[digits.length()];
        char[][] combos = new char[digits.length()][];
        char[] builder = new char[digits.length()];
        for (int i = 0; i < combos.length; ++i) {
            combos[i] = possibilities.get(digits.charAt(i)-'2');
            builder[i] = combos[i][0];
        }
        List<String> results = new ArrayList<>();
        do {
            results.add(String.valueOf(builder));
            int i = 0;
            do {
                idx[i]++;
                if (idx[i] < combos[i].length) {
                    break;
                }
                idx[i] = 0;
                builder[i] = combos[i][0];
                i++;
                if (i >= idx.length) {
                    return results;
                }
            } while (true);
            builder[i] = combos[i][idx[i]];
        } while (true);
    }
}
