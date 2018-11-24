package net.virtualinfinity.leetcode.medianoftwosortedarrays;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {
    @ParameterizedTest
    @MethodSource
    public void testFindMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] combined = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, combined, nums1.length, nums2.length);
        Arrays.sort(combined);
        final double expected;
        if ((combined.length & 1) == 1) {
            expected = combined[combined.length/2];
        } else {
            expected = (combined[combined.length/2] + combined[combined.length/2 - 1]) / 2.0;
        }
        double result = new Solution().findMedianSortedArrays(nums1, nums2);

        assertEquals(expected, result);
    }

    private static Stream<Arguments> testFindMedianSortedArrays() {
        return Stream.of(
                Arguments.arguments(nums(1, 3), nums(2)),
                Arguments.arguments(nums(1, 2), nums(3, 4)),
                Arguments.arguments(nums(1), nums()),
                Arguments.arguments(nums(), nums(1)),
                Arguments.arguments(nums(1), nums(2)),
                Arguments.arguments(nums(1, 2), nums()),
                Arguments.arguments(nums(1, 2), nums(3))
        );
    }

    public static int[] nums(int... nums) {
        return nums;
    }

}