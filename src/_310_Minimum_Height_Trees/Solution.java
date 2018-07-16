package _310_Minimum_Height_Trees;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[][] distance = new int[n][n];
        for (int i = 0; i < n; ++i) {
            int[] tmpRootDis = distance[i];
            for (int j = 0; j < n; ++j) tmpRootDis[j] = -1;
            tmpRootDis[i] = 0;
            boolean changed = false;
            do {
                changed = false;
                for (int j = 0; j < edges.length; ++j) {
                    int[] tmpEdge = edges[j];
                    if (tmpRootDis[tmpEdge[0]] != -1) {
                        if (tmpRootDis[tmpEdge[1]] == -1) {
                            tmpRootDis[tmpEdge[1]] = tmpRootDis[tmpEdge[0]] + 1;
                            changed = true;
                        } else if (tmpRootDis[tmpEdge[0]] + 1 < tmpRootDis[tmpEdge[1]]) {
                            tmpRootDis[tmpEdge[1]] = tmpRootDis[tmpEdge[0]] + 1;
                            changed = true;
                        }
                    }
                    if (tmpRootDis[tmpEdge[1]] != -1) {
                        if (tmpRootDis[tmpEdge[0]] == -1) {
                            tmpRootDis[tmpEdge[0]] = tmpRootDis[tmpEdge[1]] + 1;
                            changed = true;
                        } else if (tmpRootDis[tmpEdge[1]] + 1 < tmpRootDis[tmpEdge[0]]) {
                            tmpRootDis[tmpEdge[0]] = tmpRootDis[tmpEdge[1]] + 1;
                            changed=true;
                        }
                    }
                }
            } while (changed);
        }
        int[] max = new int[n];
        for (int i = 0; i < n; ++i) {
            max[i] = Integer.MIN_VALUE;
            for (int j : distance[i]) max[i] = Math.max(max[i], j);
        }
        LinkedList<Integer> result = new LinkedList<>();
        int iMin = 0;
        for (int i = 0; i < n; ++i) {
            if (max[i] < max[iMin]) {
                result = new LinkedList<>();
                result.add(i);
                iMin = i;
            } else if (max[i] == max[iMin]) {
                result.add(i);
            }
        }
        return result;
    }
}
