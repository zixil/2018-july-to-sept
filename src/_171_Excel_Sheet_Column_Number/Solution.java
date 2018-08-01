package _171_Excel_Sheet_Column_Number;

public class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for (char i : s.toCharArray()) {
            res *= 26;
            res += i - 'A' + 1;
        }
        return res;
    }
}
