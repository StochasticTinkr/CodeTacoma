package net.virtualinfinity.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int length = 1;
        int position = 0;
        Map<Character, Integer> map = new HashMap<>();
        map.put(s.charAt(0), 1);
        while (position + length < s.length()) {
            map.merge(s.charAt(position + length), 1, (a, b) -> a + b);
            boolean hasDups = map.values().stream().anyMatch(count -> count > 1);
            if (!hasDups) {
                ++length;
            } else {
                map.compute(s.charAt(position), (ignored, count) -> count == 1 ? null : count - 1);
                ++position;
            }
        }
        return length;
    }
}
