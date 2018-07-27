package _416_Partition_Equal_Subset_Sum;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    int[] nums;
    HashSet<Integer>[] can;

    public boolean canPartition(int[] nums) {
        this.nums = nums;
        can = new HashSet[nums.length];
        for (int i = 0; i < nums.length; ++i)
            can[i] = new HashSet<>();
        return canPartition(nums.length, 0);
    }

    public boolean canPartition(int end, int sum) {
        if (can[end - 1].contains(sum)) return false;
        boolean result;
        if (end == 1)
            result = nums[0] == sum;
        else
            result = canPartition(end - 1, sum - nums[end - 1]) || canPartition(end - 1, sum + nums[end - 1]);
        if (result) return true;
        can[end - 1].add(sum);
        return result;
    }
}
