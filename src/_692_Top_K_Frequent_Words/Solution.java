package _692_Top_K_Frequent_Words;

import java.util.*;

public class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String i : words) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        TreeSet<Comparable[]> set = new TreeSet<>((o1, o2) -> {
            int cmp = o1[1].compareTo(o2[1]);
            return cmp == 0 ? o1[0].compareTo(o2[0]) : -cmp;
        });
        for (String i : map.keySet()) {
            Comparable[] array = {i, map.get(i)};
            set.add(array);
        }
        List<String> result = new LinkedList<>();
        for (Comparable[] i : set) {
            if (k-- == 0) break;
            result.add((String) i[0]);
        }
        return result;
    }
}
