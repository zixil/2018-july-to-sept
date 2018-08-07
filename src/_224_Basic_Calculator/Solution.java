package _224_Basic_Calculator;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    static final HashSet<Character> opMap = new HashSet<>() {{
        add('+');
        add('-');
        add('(');
        add(')');
    }};
    static final HashSet<String> opStrMap = new HashSet<>() {{
        add("+");
        add("-");
    }};
    char[] c;

    public int calculate(String s) {
        c = s.toCharArray();
        int newLen = 0;
        for (int i = 0; i < c.length; ++i) {
            if (c[i] != ' ') {
                c[newLen++] = c[i];
            }
        }
        s = String.valueOf(c, 0, newLen);
        LinkedList<String> list = new LinkedList<>();
        int pre = 0;
        for (int i = 0; i < newLen; ++i) {
            if (opMap.contains(c[i])) {
                if (i != pre)
                    list.add(s.substring(pre, i));
                list.add(s.substring(i, i + 1));
                pre = i + 1;
            }
        }
        if (pre != newLen)
            list.add(s.substring(pre, newLen));
        Stack<String> stack = new Stack<>();
        for (String i : list) {
            if (stack.isEmpty()) {
                stack.push(i);
                continue;
            }
            if (opStrMap.contains(i) || i.equals("(")) {
                stack.push(i);
                continue;
            }
            if (i.equals(")")) {
                String tmp = stack.pop();
                stack.pop();
                i = tmp;
            }
            int tmpInt = Integer.parseInt(i);
            while (!stack.isEmpty() && opStrMap.contains(stack.peek())) {
                tmpInt = calc(stack.pop(), stack.pop(), tmpInt);
            }
            stack.push(String.valueOf(tmpInt));
        }
        return Integer.parseInt(stack.pop());
    }

    int calc(String op, String a, int b) {
        if (op.equals("+")) return Integer.parseInt(a) + b;
        else return Integer.parseInt(a) - b;
    }
}
