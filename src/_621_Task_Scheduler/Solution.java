package _621_Task_Scheduler;

import java.util.Arrays;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] count = new int[26];
        for (char i : tasks) ++count[i - 'A'];
        Arrays.sort(count);
        for (int i = 0; i < 26; ++i) {
            if (count[25 - i] != count[25]) return Math.max(tasks.length, (count[25] - 1) * (n + 1) + i);
        }
        return Math.max(tasks.length, count[25] * (n + 1));
        
    }
}
