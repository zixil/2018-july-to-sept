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
        return list.stream().filter(
                (i) -> i.size() >= 2
        ).map(
                (i) -> i.stream().map((n) -> nums[n]).collect(Collectors.toList())
        ).collect(Collectors.toList());
    }

    List<LinkedList<Integer>> findSubsequences(LinkedList<Integer> pre, int start) {
        int cur = nums[start];
        LinkedList<Integer> subarray = new LinkedList<>(pre);
        List<LinkedList<Integer>> result = new LinkedList<>();
        for (int i = start; i < nums.length; ++i) {
            if (nums[i] == cur) {
                subarray.add(i);
                LinkedList<Integer> curList = new LinkedList<>(subarray);
                result.add(curList);
            }
        }

        for (LinkedList<Integer> curPre : new LinkedList<>(result)) {
            HashSet<Integer> starts = new HashSet<>();
            for (int i = curPre.getLast() + 1; i < nums.length; ++i) {
                if (nums[i] > cur && !starts.contains(nums[i])) {
                    result.addAll(findSubsequences(curPre, i));
                    starts.add(nums[i]);
                }
            }
        }
        return result;
    }
}
