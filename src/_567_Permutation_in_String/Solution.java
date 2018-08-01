package _567_Permutation_in_String;

public class Solution {
    int len1, len2;
    int[] count1 = new int[26];
    int[] count2 = new int[26];

    public boolean checkInclusion(String s1, String s2) {
        len1 = s1.length();
        len2 = s2.length();
        if (len1 > len2) return false;
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        for (int i = 0; i < len1; ++i) {
            count1[c1[i] - 'a']++;
            count2[c2[i] - 'a']++;
        }
        if (same()) return true;
        for (int i = len1; i < len2; ++i) {
            count2[c2[i] - 'a']++;
            count2[c2[i - len1] - 'a']--;
            if (same()) return true;
        }
        return false;
    }

    boolean same() {
        for (int i = 0; i < 26; ++i) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
