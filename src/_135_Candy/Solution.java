package _135_Candy;

import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;

public class Solution {
    public int candy(int[] ratings) {
        if (ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        LinkedList<Integer> max = new LinkedList<>();
        max.add(0);
        for (int i = 1; i < ratings.length - 1; ++i) {
            if (ratings[i] >= ratings[i - 1] && ratings[i] >= ratings[i + 1]) max.add(i);
        }
        max.add(ratings.length - 1);
        int[][] cluster = new int[max.size()][];
        Iterator<Integer> iMax = max.iterator();
        int[] result = new int[ratings.length];
        int pre = iMax.next();
        int cur;
        int iCluster = 0;
        while (iMax.hasNext()) {
            cur = iMax.next();
            cluster[iCluster] = new int[cur - pre + 1];
            int[] tmpCluster = cluster[iCluster++];
            tmpCluster[0] = 0;
            int min = 0;
            for (int i = 1; i <= cur - pre; ++i) {
                tmpCluster[i] = tmpCluster[i - 1] + Integer.compare(ratings[pre + i], ratings[pre + i - 1]);
                min = Math.min(min, tmpCluster[i]);
            }
            result[pre] = Math.max(result[pre], tmpCluster[0] - min + 1);
            for (int i = 1; i <= cur - pre; ++i) {
                tmpCluster[i] = tmpCluster[i] - min + 1;
                result[pre + i] = tmpCluster[i];
            }
            pre = cur;
        }
        int sum = 0;
        for (int i : result) sum += i;
        return sum;
    }
}
