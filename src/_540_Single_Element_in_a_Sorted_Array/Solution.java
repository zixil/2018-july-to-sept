package _540_Single_Element_in_a_Sorted_Array;

public class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums[0]!=nums[1])
            return nums[0];
        int min = 0, max = nums.length / 2 - 1;
        if (nums[max * 2] == nums[max * 2 + 1])
            return nums[max * 2 + 2];
        while (max > min + 1) {
            int mid = (min + max) / 2;
            if (nums[mid * 2] == nums[mid * 2 + 1]) {
                min = mid;
            } else max = mid;
        }
        return nums[max * 2];
    }
}
