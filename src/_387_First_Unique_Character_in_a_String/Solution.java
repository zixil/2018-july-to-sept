package _387_First_Unique_Character_in_a_String;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int firstUniqChar(String s) {
        char[] s1 = s.toCharArray();
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s1.length; ++i) {
            map.put(s1[i], map.containsKey(s1[i]) ? -1 : i);
        }
        int min = -1;
        for (int i : map.values()) {
            if (min < 0 || i >= 0 && i < min) min = i;
        }
        return min;
    }
}
