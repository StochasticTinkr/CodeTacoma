package net.virtualinfinity.leetcode.kthsmallest;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        return Stream.of(matrix)
                .flatMapToInt(IntStream::of)
                .sorted()
                .skip(k - 1)
                .findFirst()
                .orElse(0);
    }
}