package net.virtualinfinity.leetcode.medianoftwosortedarrays;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int totalLength = nums1.length + nums2.length;
        boolean odd = 0 != (totalLength & 1);
        int skip = (totalLength + 1) / 2;
        final IntQueue a = new IntQueue(nums1);
        final IntQueue b = new IntQueue(nums2);
        while (skip > 1) {
            next(a, b);
            --skip;
        }
        if (odd) {
            return next(a, b);
        } else {
            return (next(a, b) + next(a, b)) * .5;
        }
    }

    private int next(IntQueue a, IntQueue b) {
        boolean aIsNext = a.hasNext() && (!b.hasNext() || a.peek() < b.peek());
        if (aIsNext) {
            return a.next();
        } else {
            return b.next();
        }
    }

    private static class IntQueue {
        private final int[] values;
        private int position;

        public IntQueue(int[] values) {
            this.values = values;
        }

        boolean hasNext() {
            return position < values.length;
        }

        int next() {
            return values[position++];
        }

        int peek() {
            return values[position];
        }
    }
}
