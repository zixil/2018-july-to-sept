package _47_Permutations_II;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums)
            map.put(i, map.getOrDefault(i, 0) + 1);
        int countSize = map.keySet().size();
        List<Pair<List<Integer>, Map<Integer, Integer>>> lists = new LinkedList<>();
        for (int i : map.keySet()) {
            List<Integer> newList = new LinkedList<>();
            newList.add(i);
            Map<Integer, Integer> newMap = new HashMap<>();
            newMap.putAll(map);
            int iCount = newMap.get(i);
            if (iCount == 0) newMap.remove(i);
            else newMap.put(i, iCount - 1);
            lists.add(new Pair<>(newList, newMap));
        }
        return null;
    }
}
