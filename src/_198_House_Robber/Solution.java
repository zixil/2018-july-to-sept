package _198_House_Robber;

import java.util.Arrays;

public class Solution {
    int[] _nums;
    int[] results;

    public int rob(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        _nums = nums;
        results = new int[length];
        results[0] = nums[0];
        for (int i = 1; i < length; ++i) results[i] = -1;
        return rob(length);
    }

    public int rob(int end) {
        if (results[end - 1] != -1) return results[end - 1];
        if (end == 2) return results[1] = Math.max(_nums[0], _nums[1]);
        if (end == 3) return results[2] = Math.max(_nums[0] + _nums[2], _nums[1]);
        return results[end - 1] = Math.max(rob(end - 2) + _nums[end - 1], rob(end - 3) + _nums[end - 2]);
    }
}