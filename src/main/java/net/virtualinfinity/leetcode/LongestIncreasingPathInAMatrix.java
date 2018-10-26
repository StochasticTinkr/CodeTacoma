package net.virtualinfinity.leetcode;

/**
 * Solves https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 */
public class LongestIncreasingPathInAMatrix {
    public int longestIncreasingPath(int[][] matrix) {
        final int width = matrix.length;
        if (width < 1) {
            return 0;
        }
        final int height = matrix[0].length;
        final int[][] lengths = new int[width][height];
        int maxLen = 0;
        for (int x = 0; x < width; ++x) {
            for (int y = 0; y < height; ++y) {
                int len = findLengths(x, y, matrix, lengths, width, height);
                if (maxLen < len) {
                    maxLen = len;
                }
            }
        }
        return maxLen;
    }

    private int findLengths(int x, int y, int[][] matrix, int[][] lengths, int width, int height) {
        if (x < 0 || x >= width || y < 0 || y >= height) {
            return 0;
        }
        if (lengths[x][y] != 0) {
            return lengths[x][y];
        }
        int[][] coords = {
                {x - 1, y},
                {x + 1, y},
                {x, y - 1},
                {x, y + 1}
        };
        int value = matrix[x][y];
        int length = 1;
        for (int[] coord : coords) {
            int x1 = coord[0];
            int y1 = coord[1];
            if (x1 < 0 || x1 >= width || y1 < 0 || y1 >= height) {
                continue;
            }
            if (matrix[x1][y1] > value) {
                int nextLength = findLengths(x1, y1, matrix, lengths, width, height) + 1;
                if (nextLength > length) {
                    length = nextLength;
                }
            }
        }

        lengths[x][y] = length;

        return length;
    }
}
