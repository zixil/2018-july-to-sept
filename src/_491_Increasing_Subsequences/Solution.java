package _491_Increasing_Subsequences;

import DataStructures.ListNode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution {
    int[] nums;

    public List<List<Integer>> findSubsequences(int[] nums) {
        this.nums = nums;
        List<List<Integer>> list = new LinkedList<>();
        HashSet<Integer> start = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (!start.contains(nums[i])) {
                list.addAll(findSubsequences(new LinkedList<>(), i));
                start.add(nums[i]);
            }
        }
        return list;
    }

    List<LinkedList<Integer>> findSubsequences(LinkedList<Integer> pre, int start) {
        int cur = nums[start];
        LinkedList<Integer> subarray = new LinkedList<>(pre);
        List<LinkedList<Integer>> result = new LinkedList<>();
        for (int i = start; i < nums.length; ++i) {
            if (nums[i] == cur) {
                subarray.add(nums[i]);
                if (subarray.size() >= 2)
                    result.add(new LinkedList<>(subarray));
                HashSet<Integer> starts = new HashSet<>();
                for (int j = i + 1; j < nums.length; ++j) {
                    if (nums[j] > cur && !starts.contains(nums[j])) {
                        result.addAll(findSubsequences(subarray, j));
                        starts.add(nums[j]);
                    }
                }
            }
        }
        return result;
    }
}
