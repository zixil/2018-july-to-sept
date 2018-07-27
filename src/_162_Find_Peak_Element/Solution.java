package _162_Find_Peak_Element;

public class Solution {
    int[] nums;

    public int findPeakElement(int[] nums) {
        this.nums = nums;
        return findPeakElement(0, nums.length);
    }

    public int findPeakElement(int begin, int end) {
        if (end - begin == 1) return begin;
        int mid = (begin + end - 1) / 2;
        return nums[mid] > nums[mid + 1] ? findPeakElement(begin, mid + 1) : findPeakElement(mid + 1, end);
    }
}
