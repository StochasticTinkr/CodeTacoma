package net.virtualinfinity.leetcode;

import java.util.Arrays;

/**
 * Solves problem https://leetcode.com/problems/longest-increasing-subsequence/
 */
public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int... nums) {
        int size = nums.length;
        int[] values = new int[size];
        int len = 0;
        for (int val : nums) {
            int i = Arrays.binarySearch(values, 0, len, val);
            if (i < 0) {
                i = -i - 1;
            }
            values[i] = val;
            if (len == i) {
                ++len;
            }
        }
        return len;
    }
}
