package _283_Move_Zeroes;

public class Solution {
    public void moveZeroes(int[] nums) {
        int newI = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != 0) nums[newI++] = nums[i];
        }
        for (int i = newI; i < nums.length; ++i) {
            nums[i] = 0;
        }
    }
}
