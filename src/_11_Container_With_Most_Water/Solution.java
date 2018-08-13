package _11_Container_With_Most_Water;

import java.util.HashSet;

public class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int max = 0;
        while (left < right) {
            int vol = Math.min(height[left], height[right]) * (right - left);
            max = Math.max(max, vol);
            if (height[left] < height[right]) ++left;
            else --right;
        }
        return max;
    }
}
