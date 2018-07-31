package _91_Decode_Ways;

public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if (len == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        if (len == 1) return 1;
        if (s.charAt(1) == '0' && s.charAt(0) != '1' && s.charAt(0) != '2')
            return 0;
        int[] dp = new int[len];
        dp[0] = 1;
        int tmp = Integer.valueOf(s.substring(0, 2));
        if (tmp <= 26 && tmp > 10 && tmp != 20)
            dp[1] = 2;
        else
            dp[1] = 1;
        for (int i = 2; i < len; ++i) {
            if (s.charAt(i) == '0' && s.charAt(i - 1) != '1' && s.charAt(i - 1) != '2')
                return 0;
            tmp = Integer.valueOf(s.substring(i - 1, i + 1));
            if (tmp == 10 || tmp == 20)
                dp[i] = dp[i - 2];
            else if (tmp > 26 || tmp < 10)
                dp[i] = dp[i - 1];
            else
                dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[len - 1];
    }
}
