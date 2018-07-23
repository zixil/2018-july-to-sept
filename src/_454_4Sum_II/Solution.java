package _454_4Sum_II;

import java.util.HashMap;

public class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int result = 0;
        for (int i : A) for (int j : B) map.put(i + j, map.getOrDefault(i + j, 0) + 1);
        for (int i : C) for (int j : D) result += map.getOrDefault(-(i + j), 0);
        return result;
    }
}
