package _399_Evaluate_Division;

import java.util.HashMap;

public class Solution {
    double[][] edges;
    int numV = 0;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] i : equations) {
            if (!map.containsKey(i[0]))
                map.put(i[0], numV++);
            if (!map.containsKey(i[1]))
                map.put(i[1], numV++);
        }
        edges = new double[numV][numV];
        for (int i = 0; i < equations.length; ++i) {
            int a1 = map.get(equations[i][0]), a2 = map.get(equations[i][1]);
            edges[a1][a2] = values[i];
            edges[a2][a1] = 1 / values[i];
        }
        expand();
        double[] res = new double[queries.length];
        for (int i = 0; i < queries.length; ++i) {
            int a1 = map.getOrDefault(queries[i][0], -1), a2 = map.getOrDefault(queries[i][1], -1);
            if (a1 == -1 || a2 == -1) {
                res[i] = -1;
                continue;
            }
            res[i] = edges[a1][a2];
        }
        return res;
    }

    void expand() {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < numV; ++i) {
                for (int j = 0; j < numV; ++j) {
                    if (edges[i][j] != 0) {
                        for (int k = 0; k < numV; ++k) {
                            if (edges[i][k] == 0 && edges[j][k] != 0) {
                                edges[i][k] = edges[i][j] * edges[j][k];
                                changed = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
