package _785_Is_Graph_Bipartite;

import java.util.Arrays;

public class Solution {

    int[] divide;
    int[][] graph;

    public boolean isBipartite(int[][] graph) {
        if (graph.length == 1) return true;
        this.graph = graph;
        divide = new int[graph.length];
        for (int i = 0; i < graph.length; ++i) {
            if (divide[i] == 0) {
                divide[i] = 1;
                if (!setPath(i)) return false;
            }
        }
        return true;
    }

    boolean setPath(int n) {
        for (int i : graph[n]) {
            if (divide[i] == 0) {
                divide[i] = -divide[n];
                if (!setPath(i)) return false;
            } else if (divide[i] == divide[n]) return false;
        }
        return true;
    }
}
