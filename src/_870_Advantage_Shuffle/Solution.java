package _870_Advantage_Shuffle;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

public class Solution {
    public int[] advantageCount(int[] A, int[] B) {
        int len = A.length;
        Pair<Integer, Integer>[] a = new Pair[len], b = new Pair[len];
        for (int i = 0; i < len; ++i) {
            a[i] = new Pair<>(A[i], i);
            b[i] = new Pair<>(B[i], i);
        }
        Arrays.sort(a, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o1.getKey(), o2.getKey());
            }
        });
        Arrays.sort(b, new Comparator<Pair<Integer, Integer>>() {
            @Override
            public int compare(Pair<Integer, Integer> o1, Pair<Integer, Integer> o2) {
                return Integer.compare(o1.getKey(), o2.getKey());
            }
        });
        LinkedList<Pair<Integer, Integer>> head = new LinkedList<>();
        LinkedList<Pair<Integer, Integer>> tail = new LinkedList<>();
        outer:
        for (int i = 0, j = 0; i < len; ++i, ++j) {
            while (a[i].getKey() <= b[j].getKey()) {
                tail.add(a[i++]);
                if (i >= len)
                    break outer;
            }
            head.add(a[i]);
        }
        head.addAll(tail);
        head.toArray(a);
        for (int i = 0; i < len; ++i) {
            A[b[i].getValue()] = a[i].getKey();
        }
        return A;
    }
}
