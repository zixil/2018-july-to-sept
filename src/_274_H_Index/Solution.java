package _274_H_Index;

import java.util.Arrays;

public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0)
            return 0;
        Arrays.sort(citations);
        int[] count = new int[len];
        int newLen = 0;
        for (int i = 0; i < len; ++i) {
            if (citations[newLen] == citations[i]) {
                ++count[newLen];
            } else {
                citations[++newLen] = citations[i];
                count[newLen] = count[newLen - 1] + 1;
            }
        }
        ++newLen;
        for (int i = newLen - 1; i >= 1; --i) {
            if (len - count[i - 1] >= citations[i])
                return Math.max(citations[i],len - count[i]);
        }
        if (len >= citations[0])
            return Math.max(citations[0],len - count[0]);
        else return len;
    }
}
