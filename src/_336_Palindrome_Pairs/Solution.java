package _336_Palindrome_Pairs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new LinkedList<>();
        char[][] cs = new char[words.length][];
        for (int i = 0; i < words.length; ++i) {
            cs[i] = words[i].toCharArray();
        }
        for (int i = 0; i < words.length; ++i) {
            for (int j = i + 1; j < words.length; ++j) {
                if (palindromePair(cs[i], cs[j])) result.add(Arrays.asList(i, j));
                if (palindromePair(cs[j], cs[i])) result.add(Arrays.asList(j, i));
            }
        }
        return result;
    }


    boolean palindromePair(char[] c1, char[] c2) {
        int len1 = c1.length, len2 = c2.length;
        if (len1 >= len2) {
            for (int i = 0; i < len2; ++i)
                if (c1[i] != c2[len2 - 1 - i]) return false;
            for (int i = len2; i < len1; ++i)
                if (c1[i] != c1[len1 + len2 - 1 - i]) return false;
        } else {
            for (int i = 0; i < len1; ++i)
                if (c1[i] != c2[len2 - 1 - i]) return false;
            for (int i = len1; i < len2; ++i)
                if (c2[i - len1] != c2[len2 - 1 - i]) return false;
        }
        return true;
    }
}
