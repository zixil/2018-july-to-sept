package _680_Valid_Palindrome_II;

public class Solution {
    char[] c;
    int len;

    public boolean validPalindrome(String s) {
        c = s.toCharArray();
        len = s.length();
        for (int i = 0; i < len / 2; ++i) {
            if (c[i] != c[len - 1 - i])
                return deleteI(i) || deleteLenI(i);
        }
        return true;
    }

    boolean deleteI(int i) {
        for (int k = i; k < (len - 1) / 2; ++k) {
            if (c[k + 1] != c[len - 1 - k]) return false;
        }
        return true;
    }

    boolean deleteLenI(int i) {
        for (int k = i; k < (len - 1) / 2; ++k) {
            if (c[k] != c[len - 2 - k]) return false;
        }
        return true;
    }
}
