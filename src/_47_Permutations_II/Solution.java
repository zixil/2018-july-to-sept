package _47_Permutations_II;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result=new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int countSize = map.keySet().size();
        int[] count = new int[countSize];
        int[] countKey = new int[countSize];
        int i = 0;
        for (int k : map.keySet()) {
            countKey[i] = k;
            count[i] = map.get(k);
            ++i;
        }
        return null;
    }
}
