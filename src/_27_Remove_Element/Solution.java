package _27_Remove_Element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int i = 0;
        outer:
        for (int j = 0; j < nums.length; ++i, ++j) {
            while (nums[j] == val) {
                ++j;
                if (j >= nums.length)
                    break outer;
            }
            nums[i] = nums[j];
        }
        return i;
    }
}
