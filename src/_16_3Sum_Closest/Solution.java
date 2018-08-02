package _16_3Sum_Closest;

import java.util.Arrays;

public class Solution {
    int[] nums;
    int len;

    public int threeSumClosest(int[] nums, int target) {
        //Arrays.sort(nums);
        this.nums = nums;
        len = nums.length;
        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < len - 2; ++i) {
            int newDiff = twoSumClosest(i + 1, target - nums[i]);
            if (Math.abs(diff) > Math.abs(newDiff)) diff = newDiff;
        }
        return target - diff;
    }

    int twoSumClosest(int start, int target) {
        int diff = Integer.MAX_VALUE;
        for (int i = start; i < len - 1; ++i) {
            int newDiff = oneSumClosest(i + 1, target - nums[i]);
            if (Math.abs(diff) > Math.abs(newDiff)) diff = newDiff;
        }
        return diff;
    }

    int oneSumClosest(int start, int target) {
        int diff = Integer.MAX_VALUE;
        for (int i = start; i < len; ++i) {
            int newDiff = target - nums[i];
            if (Math.abs(diff) > Math.abs(newDiff)) diff = newDiff;
            if (diff == 0) return 0;
        }
        return diff;
    }
}
