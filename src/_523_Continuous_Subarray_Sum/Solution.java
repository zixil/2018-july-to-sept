package _523_Continuous_Subarray_Sum;

import java.util.Arrays;

public class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] sum = Arrays.copyOf(nums, nums.length - 1);
        if (k != 0) {
            for (int i = 1; i < nums.length; ++i) {
                for (int j = 0; j < nums.length - i; ++j) {
                    sum[j] += nums[j + i];
                    if (sum[j] % k == 0) return true;
                }
            }
        } else {
            for (int i = 1; i < nums.length; ++i) {
                for (int j = 0; j < nums.length - i; ++j) {
                    sum[j] += nums[j + i];
                    if (sum[j] == 0) return true;
                }
            }
        }
        return false;
    }
}
