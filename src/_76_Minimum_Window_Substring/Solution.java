package _76_Minimum_Window_Substring;

public class Solution {
    char[] c;

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char i : t.toCharArray()) map[i]++;
        c = s.toCharArray();
        int counter = t.length(), begin = 0, end = 0, d = Integer.MAX_VALUE, head = 0;
        while (end < c.length) {
            if (map[c[end++]]-- > 0)
                counter--;
            while (counter == 0) {
                if (end - begin < d)
                    d = end - (head = begin);
                if (map[c[begin++]]++ == 0)
                    counter++;
            }
        }
        return d == Integer.MAX_VALUE ? "" : s.substring(head, head + d);

    }
}
