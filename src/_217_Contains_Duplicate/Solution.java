package _217_Contains_Duplicate;

import java.util.HashSet;

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums) {
            if (set.contains(i)) return true;
            set.add(i);
        }
        return false;
    }
}
