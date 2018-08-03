package _241_Different_Ways_to_Add_Parentheses;

import java.util.*;

public class Solution {
    static final HashSet<Character> set = new HashSet<Character>() {{
        add('+');
        add('-');
        add('*');
    }};
    Integer[] nums;
    Character[] ops;


    public List<Integer> diffWaysToCompute(String input) {
        LinkedList<Integer> op = new LinkedList<>();
        if (input.equals("")) return op;
        char[] s = input.toCharArray();
        for (int i = 0; i < s.length; ++i) {
            if (set.contains(s[i])) op.add(i);
        }
        op.add(s.length);
        LinkedList<Integer> num = new LinkedList<>();
        int pre = 0;
        for (int i : op) {
            num.add(Integer.parseInt(input.substring(pre, i)));
            pre = i + 1;
        }
        nums = new Integer[num.size()];
        num.toArray(nums);
        ops = new Character[op.size() - 1];
        Iterator<Integer> iter = op.iterator();
        for (int i = 0; i < ops.length; ++i) ops[i] = s[iter.next()];
        return diffWaysToCompute(0, nums.length, 0, ops.length);
    }

    List<Integer> diffWaysToCompute(int nS, int nE, int oS, int oE) {
        List<Integer> res = new LinkedList<>();
        if (oS == oE) {
            res.add(nums[nS]);
            return res;
        }
        for (int i = oS; i < oE; ++i) {
            List<Integer> left = diffWaysToCompute(nS, i + 1, oS, i);
            List<Integer> right = diffWaysToCompute(i + 1, nE, i + 1, oE);
            for (int l : left) {
                for (int r : right) {
                    res.add(fun(l, r, i));
                }
            }
        }
        return res;
    }

    int fun(int a, int b, int opI) {
        if (ops[opI] == '+') return a + b;
        if (ops[opI] == '-') return a - b;
        return a * b;
    }


}
