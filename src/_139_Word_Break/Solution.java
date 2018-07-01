package _139_Word_Break;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        int sEnd = s.length();
        boolean[] dp = new boolean[sEnd+1];
        dp[0] = true;
        for (int i = 1; i <= sEnd; ++i) {
            for (int j = 0; j < i; ++j) {
                dp[i]=false;
                for (String k : wordDict) {
                    if (dp[j] && s.substring(j, i).equals(k)) {
                        dp[i] = true;
                    }
                }
                if(dp[i]) break;
            }
        }
        return dp[sEnd];
    }

}
