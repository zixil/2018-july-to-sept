package _268_Missing_Number;

public class Solution {
    public int missingNumber(int[] nums) {
        int sum = (0 + nums.length) * (nums.length + 1) / 2;
        for (int i : nums) sum -= i;
        return sum;
    }
}
