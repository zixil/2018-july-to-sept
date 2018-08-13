package _636_Exclusive_Time_of_Functions;

import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<int[]> stack = new Stack<>();
        for (String i : logs) {
            String[] tmp = i.split(":");
            if (tmp[1].equals("start")) {
                int[] array = {Integer.parseInt(tmp[0]), 1, Integer.parseInt(tmp[2]), 0};
                stack.push(array);
            } else {
                int[] preArray = stack.pop();
                int interval = Integer.parseInt(tmp[2]) - preArray[2];
                res[Integer.parseInt(tmp[0])] = interval - preArray[4];
                stack.peek()[4] += interval;
            }
        }
        return res;
    }
}
