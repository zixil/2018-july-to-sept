package _753_Cracking_the_Safe;

import java.util.*;

public class Solution {
    HashMap<String, Stack<Character>> map=new HashMap<>();
    int k;
    char[] A;
    StringBuilder s;

    public String crackSafe(int n, int k) {
        this.k = k;
        A = new char[k];
        for (char i = 0; i < k; ++i) {
            A[i] = (char) (i + '0');
        }
        if(n==1) return String.valueOf(A);
        getMap("", n - 1);
        s = new StringBuilder();
        for (int i = 0; i < n - 1; ++i) {
            s.append(A[0]);
        }
        if(k==1) return s.append(A[0]).toString();
        DFS(s.toString());
        s.append(s.substring(0,1));
        return s.toString();
    }

    void getMap(String s, int curN) {
        if (curN == 0) {
            Stack<Character> stack = new Stack<>();
            for (int i = '0'; i < k + '0'; ++i) stack.push((char) i);
            map.put(s, stack);
        } else for (char i : A)
            getMap(s + i, curN - 1);
    }

    void DFS(String curS) {
        char tmp;
        String tmpS;
        do {
            if (map.get(curS).isEmpty()) return;
            tmp = map.get(curS).pop();
            tmpS = curS.substring(1) +String.valueOf(tmp);
        } while (map.get(tmpS).isEmpty());
        s.append(tmp);
        DFS(tmpS);
    }
}
