package _17_Letter_Combinations_of_a_Phone_Number;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int len;
    char[][] map = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public List<String> letterCombinations(String digits) {
        len = digits.length();
        LinkedList<String> product = new LinkedList<>();
        if (len == 0) return product;
        char[] c = digits.toCharArray();
        for (char i : map[c[0] - '2']) product.add(String.valueOf(i));
        int i = 1;
        while (i < len) {
            LinkedList<String> tmpList = new LinkedList<>();
            char[] tmpMap = map[c[i] - '2'];
            while (!product.isEmpty()) {
                String tmpString = product.poll();
                for (char k : tmpMap) tmpList.add(tmpString + String.valueOf(k));
            }
            product = tmpList;
            ++i;
        }
        return product;
    }
}
