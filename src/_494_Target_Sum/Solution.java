package _494_Target_Sum;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return findTargetSumWays(nums, S, nums.length);
    }

    public int findTargetSumWays(int[] nums, int S, int end) {
        if (end == 1) {
            int tmp = 0;
            if (nums[0] == S) ++tmp;
            if (nums[0] == -S) ++tmp;
            return tmp;
        } else {
            int tmp = nums[end - 1];
            if (tmp == 0) return 2 * findTargetSumWays(nums, S, end - 1);
            else return findTargetSumWays(nums, S - tmp, end - 1) + findTargetSumWays(nums, S + tmp, end - 1);
        }
    }
}