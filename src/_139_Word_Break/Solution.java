package _139_Word_Break;

import java.util.List;

public class Solution {
    int sEnd;

    public boolean wordBreak(String s, List<String> wordDict) {
        sEnd = s.length();
        return wordBreak(s, wordDict, 0);
    }

    public boolean wordBreak(String s, List<String> wordDict, int start) {
        int sLen = sEnd - start;
        for (String i : wordDict) {
            int len = i.length();
            if (len > sLen) continue;
            if (s.substring(start, start + len).equals(i)) {
                if (len == sLen || wordBreak(s, wordDict, start + len))
                    return true;
            }
        }
        return false;
    }
}
