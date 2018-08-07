package _354_Russian_Doll_Envelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    int[] vols;
    int[][] envelopes;

    public int maxEnvelopes(int[][] envelopes) {
        this.envelopes = envelopes;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0]) return -1;
                if (o1[0] == o2[0]) return Integer.compare(o1[1], o2[1]);
                return 1;
            }
        });
        vols = new int[envelopes.length];
        int max = 0;
        for (int i = 0; i < vols.length; ++i) {
            max = Math.max(max, getVol(i));
        }
        return max + 1;
    }

    int getVol(int a) {
        for (int i = 0; i < a; ++i) {
            if (envelopes[i][1] >= envelopes[a][1]) continue;
            if (envelopes[i][0] == envelopes[a][0]) break;
            vols[a] = Math.max(vols[i] + 1, vols[a]);
        }
        return vols[a];
    }
}
