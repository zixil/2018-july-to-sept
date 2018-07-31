package _96_Unique_Binary_Search_Trees;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int[] num;

    public int numTrees(int n) {
        if (num == null) {
            num = new int[n+1];
            num[0] = 1;
            num[1] = 1;
        }
        if (num[n] != 0) return num[n];
        for (int i = 0; i < n; ++i) {
            num[n] += numTrees(i) * numTrees(n - i - 1);
        }
        return num[n];
    }
}
