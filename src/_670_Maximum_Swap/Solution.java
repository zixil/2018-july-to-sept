package _670_Maximum_Swap;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maximumSwap(int num) {
        String numStr = String.valueOf(num);
        char[] c = numStr.toCharArray();
        int i = 0;
        for (; i < c.length; ++i) {
            if (c[i] != '9') {
                int max = i;
                for (int j = i; j < c.length; ++j) {
                    if (c[max] < c[j]) max = j;
                }
                if (c[max] == c[i]) continue;
                char tmp = c[max];
                c[max] = c[i];
                c[i] = tmp;
                return Integer.parseInt(String.valueOf(c));
            }
        }
        return num;
    }
}
