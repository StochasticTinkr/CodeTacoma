package net.virtualinfinity.leetcode.nextpermutation;

import java.util.Arrays;

class Solution {
    public void nextPermutation(int[] nums) {
        int last = nums.length-1;
        if (last < 0) {
            return;
        }
        int j = last-1;
        while (j >= 0 && nums[j] >= nums[j+1]) {
            --j;
        }
        int fromIndex = j + 1;
        for (int i = last; i > fromIndex; i--,++fromIndex) {
            int temp1 = nums[i];
            nums[i] = nums[fromIndex];
            nums[fromIndex] = temp1;
        }
        if (j >= 0) {
            int target = nums[j];
            int pos = Arrays.binarySearch(nums, j+1, last+1, target);
            if (pos < 0) {
                pos = -pos - 1;
            } else {
                while (nums[pos] == target && pos < last) {
                    ++pos;
                }
            }
            int temp = nums[j];
            nums[j] = nums[pos];
            nums[pos] = temp;
        }

    }

}

/*
1,2,3,4     -> 4,3
1,2,4,3     -> 3,2,4
1,3,2,4
1,3,4,2     -> 4,2,3
1,4,2,3
1,4,3,2     -> 2
2,1,3,4
2,1,4,3
2,3,1,4
2,3,4,1
2,4,1,3
2,4,3,1
3,1,2,4
3,1,4,2
3,2,1,4
3,2,4,1
3,4,1,2
3,4,2,1
4,1,2,3
4,1,3,2
4,2,1,3
4,2,3,1
4,3,1,2
4,3,2,1
*/
