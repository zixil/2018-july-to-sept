package _22_Generate_Parentheses;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Solution {
    public List<String> generateParenthesis(int n) {
        long startTime = System.currentTimeMillis();
        LinkedList<String> result = new LinkedList<>();
        if (n == 0) return result;
        LinkedList<Integer> L = new LinkedList<>(), R = new LinkedList<>();
        result.add("(");
        L.add(n - 1);
        R.add(1);
        for (int i = 1; i < n*2; ++i) {
            ListIterator<String> iS = result.listIterator();
            ListIterator<Integer> iL = L.listIterator(), iR = R.listIterator();
            while (iS.hasNext()) {
                String tmpS = iS.next();
                int tmpL = iL.next(), tmpR = iR.next();
                iS.remove();
                iL.remove();
                iR.remove();
                if (tmpL != 0) {
                    iS.add(tmpS + "(");
                    iL.add(tmpL - 1);
                    iR.add(tmpR + 1);
                }
                if (tmpR != 0) {
                    iS.add(tmpS + ")");
                    iL.add(tmpL);
                    iR.add(tmpR - 1);
                }
            }
        }
        System.out.println(System.currentTimeMillis()-startTime);
        return result;
    }
}
