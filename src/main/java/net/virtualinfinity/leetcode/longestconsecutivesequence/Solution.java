package net.virtualinfinity.leetcode.longestconsecutivesequence;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new LinkedHashSet<>();
        for (int num : nums) {
            values.add(num);
        }
        int best = 0;
        while (!values.isEmpty()) {
            Iterator<Integer> iterator = values.iterator();
            int midpoint = iterator.next();
            iterator.remove();
            int count = 1;
            int min;
            for (min = midpoint - 1; values.remove(min); --min) {
                count++;
            }
            int max;
            for (max = midpoint + 1; values.remove(max); ++max) {
                ++count;
            }
            if (best < count) {
                best = count;
            }

        }
        return best;
    }
}