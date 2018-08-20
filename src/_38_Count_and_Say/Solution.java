package _38_Count_and_Say;

public class Solution {
    public String countAndSay(int n) {
        String cur = countAndSay("1".toCharArray());
        for (int i = 1; i < n; ++i) {
            cur=countAndSay(cur.toCharArray());
        }
        return cur;
    }

    String countAndSay(char[] s) {
        StringBuilder builder = new StringBuilder();
        int count = 1;
        int cur = s[0];
        for (int i = 1; i < s.length; ++i) {
            if (s[i] == cur) ++count;
            else {
                builder.append(count).append(cur);
                count = 1;
                cur = s[i];
            }
        }
        builder.append(count).append(cur);
        return builder.toString();
    }
}
