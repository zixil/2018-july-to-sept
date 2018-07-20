package _49_Group_Anagrams;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<Pair<int[], List<String>>> list = new LinkedList<>();
        for (String i : strs) {
            char[] tmp = i.toCharArray();
            int[] map = new int[26];
            for (char c : tmp) map[c - 'a'] += 1;
            boolean exist = false;
            for (Pair<int[], List<String>> p : list) {
                int[] tmpMap = p.getKey();
                List<String> stringList = p.getValue();
                if (i.length() == stringList.get(0).length()) {
                    exist = true;
                    for (int j = 0; j < 26; ++j) {
                        if (tmpMap[j] != map[j]) {
                            exist = false;
                            break;
                        }
                    }
                    /*
                    for (char c : map) {
                        if (!tmpMap.getOrDefault(c, 0).equals(map.get(c))) {
                            exist = false;
                            break;
                        }
                    }
                    */
                    if (exist) {
                        stringList.add(i);
                        break;
                    }
                }
            }
            if (!exist) {
                List<String> newList = new LinkedList<>();
                newList.add(i);
                list.add(new Pair<>(map, newList));
            }
        }
        List<List<String>> result = new LinkedList<>();
        for (Pair<int[], List<String>> i : list) {
            result.add(i.getValue());
        }
        return result;
    }
}
