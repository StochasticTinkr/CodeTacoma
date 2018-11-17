package net.virtualinfinity.leetcode.kthsmallest;

import java.util.Arrays;

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int size = matrix.length;
        int min = matrix[0][0];
        int max = matrix[size - 1][size - 1];
        while (min < max) {
            int mid = (min + max) / 2;
            int lessThanMid = 0;
            for (int[] row : matrix) {
                int position = Arrays.binarySearch(row, mid);
                if (position < 0) {
                    position = -(position + 1);
                } else {
                    while (position < size && row[position] == mid) {
                        ++position;
                    }
                }
                lessThanMid += position;
            }
            if (lessThanMid < k) {
                min = mid + 1;
            } else {
                max = mid;
            }
        }

        return min;
    }
}