package _389_Find_the_Difference;

import java.util.HashMap;

public class Solution {
    public char findTheDifference(String s, String t) {
        char[] map = new char[26];

        for (char i : s.toCharArray()) {
            ++map[i - 'a'];
        }
        for (char i : t.toCharArray()) {
            if (map[i - 'a'] == 0) return i;
            else --map[i - 'a'];
        }
        return 0;
    }
}
