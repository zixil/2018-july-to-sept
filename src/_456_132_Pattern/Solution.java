package _456_132_Pattern;

import java.util.Stack;

public class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums.length == 0) return false;
        int[] min = new int[nums.length];
        int tmpMin = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            tmpMin = Math.min(tmpMin, nums[i - 1]);
            min[i] = tmpMin;
        }
        Stack<Integer> kStack = new Stack<>();
        kStack.push(nums[nums.length - 1]);
        for (int i = nums.length - 2; i >= 1; --i) {
            if (!kStack.isEmpty()) {
                int k = kStack.peek();
                while (k <= min[i]) {
                    kStack.pop();
                    if (kStack.isEmpty()) break;
                    k = kStack.peek();
                }
                if (!kStack.isEmpty() && kStack.peek() < nums[i])
                    return true;
            }
            if (nums[i] > min[i - 1]) kStack.push(nums[i]);
        }
        return false;
    }
}
