package _433_Minimum_Genetic_Mutation;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    int len;
    String[] bank;
    int bankLen;
    boolean[][] mutabilities;
    int[] distances;

    public int minMutation(String start, String end, String[] bank) {
        int iStart = -1, iEnd = -1;
        len = start.length();
        this.bank = bank;
        bankLen = bank.length;
        for (int i = 0; i < bankLen; ++i) {
            if (iStart == -1 && start.equals(bank[i]))
                iStart = i;
            if (iEnd == -1 && end.equals(bank[i]))
                iEnd = i;
        }
        if (iEnd == -1) return -1;
        if (iStart == -1) {
            iStart = bankLen;
            mutabilities = new boolean[bankLen + 1][bankLen + 1];
            getMutabilities();
            for (int i = 0; i < bankLen; ++i)
                mutabilities[bankLen][i] = mutabilities[i][bankLen] = mutable(start, bank[i]);
        } else {
            mutabilities = new boolean[bankLen][bankLen];
            getMutabilities();
        }
        Queue<Integer> que = new LinkedList<>();
        que.add(iStart);
        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int i = 0; i < mutabilities.length; ++i) {
                if (mutabilities[cur][i] && distances[i] > distances[cur] + 1) {
                    distances[i] = distances[cur] + 1;
                    que.add(i);
                }
            }
        }
        return distances[iEnd] == 0 ? -1 : distances[iEnd];
    }

    void getMutabilities() {
        for (int i = 0; i < bankLen; ++i) {
            for (int j = 0; j < bankLen; ++j) {
                mutabilities[i][j] = mutabilities[j][i] = mutable(bank[i], bank[j]);
            }
        }
    }

    boolean mutable(String a, String b) {
        int sum = 0;
        for (int i = 0; i < len; ++i) {
            if (a.charAt(i) != b.charAt(i) && ++sum > 1) break;
        }
        return sum <= 1;
    }


}
