package _209_Minimum_Size_Subarray_Sum;

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int result = nums.length + 1, end = 0, sum = 0;
        for (int i = 0; i < nums.length; ++i) {
            for (; end < nums.length; ++end) {
                if (sum >= s) {
                    result = Math.min(result, end - i);
                    break;
                }
                sum += nums[end];
            }
            if (sum >= s) result = Math.min(result, end - i);
            sum -= nums[i];
        }
        if (result > nums.length) return 0;
        return result;
    }
}
