package _636_Exclusive_Time_of_Functions;

import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] res = new int[n];
        Stack<String[]> stack = new Stack<>();
        for (String i : logs) {
            String[] tmp = i.split(":");
            if (tmp[1].equals("start")) {
                stack.push(tmp);
            } else {
                int id = Integer.parseInt(tmp[0]);
                int time = Integer.parseInt(tmp[2]);
                res[Integer.parseInt(tmp[0])] = Integer.parseInt(tmp[2]) - Integer.parseInt(stack.pop()[2]);
            }
        }
        return res;
    }
}
