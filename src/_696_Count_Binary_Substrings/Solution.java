package _696_Count_Binary_Substrings;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public int countBinarySubstrings(String s) {
        char[] c = s.toCharArray();
        List<Integer> list = new LinkedList<>();
        int start = 0;
        int count = 1;
        for (int i = 1; i < c.length; ++i) {
            if (c[i] == c[start]) ++count;
            else {
                start = i;
                list.add(count);
                count = 1;
            }
        }
        list.add(count);
        Integer[] array = new Integer[list.size()];
        list.toArray(array);
        int res = 0;
        for (int i = 0; i < array.length - 1; ++i) {
            res += Math.min(array[i], array[i + 1]);
        }
        return res;
    }
}
