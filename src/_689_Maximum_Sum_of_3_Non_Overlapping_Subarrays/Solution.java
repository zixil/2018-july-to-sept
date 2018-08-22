package _689_Maximum_Sum_of_3_Non_Overlapping_Subarrays;

import java.util.Arrays;

public class Solution {
    int[] sums;
    int[] leftMax;
    int[] rightMax;

    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        sums = new int[nums.length - k + 1];
        leftMax = new int[sums.length];
        rightMax = new int[sums.length];
        for (int i = 0; i < k; ++i)
            sums[0] += nums[i];
        for (int i = 1; i < nums.length - k + 1; ++i)
            sums[i] = sums[i - 1] - nums[i - 1] + nums[i + k - 1];
        for (int i = k; i < sums.length - k; ++i) {
            leftMax[i] = sums[i - k] > sums[leftMax[i - 1]] ? i - k : leftMax[i - 1];
        }
        for (int i = sums.length - k - 1; i >= k; --i) {
            rightMax[i] = rightMax[i + 1] == 0 || sums[i + k] > sums[rightMax[i + 1]] ? i + k : rightMax[i + 1];
        }
        int[] threeSums = new int[sums.length];
        int max = 0;
        for (int i = k; i < sums.length - k; ++i) {
            threeSums[i] = sums[i] + sums[leftMax[i]] + sums[rightMax[i]];
            if (threeSums[max] < threeSums[i]) max = i;
        }
        int[] array = {leftMax[max], max, rightMax[max]};
        return array;
    }
}