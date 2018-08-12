package _459_Repeated_Substring_Pattern;

public class Solution {
    char[] c;

    public boolean repeatedSubstringPattern(String s) {
        c = s.toCharArray();
        for (int i = 1; i <= c.length / 2; ++i) {
            if (c.length % i == 0 && repeatedSubstringPattern(i)) return true;
        }
        return false;
    }

    public boolean repeatedSubstringPattern(int offset) {
        for (int i = 0; i < c.length - offset; ++i) {
            if (c[i] != c[i + offset]) return false;
        }
        return true;
    }
}
