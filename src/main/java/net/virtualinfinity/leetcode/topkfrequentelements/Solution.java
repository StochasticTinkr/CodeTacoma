package net.virtualinfinity.leetcode.topkfrequentelements;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Slow solution to https://leetcode.com/problems/top-k-frequent-elements/
 */
class Solution {
    private static class Counter {
        private final int input;
        private final int count;

        private Counter(int input) {
            this(input, 1);
        }

        public Counter(int input, int count) {
            this.input = input;
            this.count = count;
        }

        public int getInput() {
            return input;
        }

        public int getCount() {
            return count;
        }

        public Counter plus(Counter counter) {
            return new Counter(input, count + counter.count);
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        return IntStream.of(nums)
                .mapToObj(Counter::new)
                .collect(
                        Collectors.groupingBy(
                                Counter::getInput, Collectors.reducing(Counter::plus)
                        )
                ).values()
                .stream()
                .map(Optional::get)
                .sorted(Comparator.comparingInt(Counter::getCount).reversed())
                .limit(k)
                .map(Counter::getInput)
                .collect(Collectors.toList());

    }
}