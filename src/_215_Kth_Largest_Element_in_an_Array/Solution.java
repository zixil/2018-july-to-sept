package _215_Kth_Largest_Element_in_an_Array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> que = new PriorityQueue<>(k+1);
        for (int i : nums) {
            que.add(i);
            if (que.size() > k) que.poll();
        }
        return que.poll();
    }
}
