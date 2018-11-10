package net.virtualinfinity.leetcode;

/**
 * https://leetcode.com/problems/trapping-rain-water/
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
        int water = 0;
        for (int i = 0, j = height.length - 1, maxLeft = height[i], maxRight = height[j]; i < j; ) {
            if (height[i] > maxLeft) {
                maxLeft = height[i];
            }
            if (height[j] > maxRight) {
                maxRight = height[j];
            }
            if (maxLeft <= maxRight) {
                if (maxLeft > height[i]) {
                    water += maxLeft - height[i];
                }
                ++i;
            } else {
                if (maxLeft > height[j]) {
                    water += maxRight - height[j];
                }
                --j;
            }
        }

        return water;
    }
}
