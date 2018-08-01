package _12_Integer_to_Roman;

public class Solution {
    final static String[] mapS = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
    final static int[] intS = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};

    public String intToRoman(int num) {
        StringBuilder res = new StringBuilder();
        for (int i = intS.length - 1; i >= 0; --i) {
            res.append(times(mapS[i], num / intS[i]));
            num %= intS[i];
        }
        return res.reverse().toString();
    }

    StringBuilder times(String s, int n) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < n; ++i) res.append(s);
        return res;
    }
}
