package net.virtualinfinity.leetcode.arithmeticslices;

public class Solution {
    public int numberOfArithmeticSlices(int[] input) {
        if (input.length < 3) {
            return 0;
        }
        int diff = input[0] - input[1];
        int stretch = 0;
        int total = 0;
        for (int i = 2; i < input.length; ++i) {
            if (diff == input[i - 1] - input[i]) {
                stretch++;
                total += stretch;
            } else {
                stretch = 0;
                diff = input[i - 1] - input[i];
            }
        }
        return total;
    }
}
