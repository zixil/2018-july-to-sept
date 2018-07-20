package _54_Spiral_Matrix;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    int rlen, clen;

    public List<Integer> spiralOrder(int[][] matrix) {
        clen = matrix.length;
        if (clen == 0) return new LinkedList<>();
        rlen = matrix[0].length;
        return spiralOrder(matrix, 0);
    }

    List<Integer> spiralOrder(int[][] matrix, int num) {
        LinkedList<Integer> result = new LinkedList<>();
        int tmpCL = clen - num * 2, tmpRL = rlen - num * 2, cLast = clen - num - 1, rLast = rlen - num - 1;
        if (tmpRL == 0 || tmpCL == 0) return result;
        if (tmpRL == 1) {
            for (int i = num; i <= cLast; ++i) result.add(matrix[i][rLast]);
            return result;
        } else if (tmpCL == 1) {
            for (int i = num; i <= rLast; ++i) result.add(matrix[cLast][i]);
            return result;
        }
        for (int i = num; i < rLast; ++i) result.add(matrix[num][i]);
        for (int i = num; i < cLast; ++i) result.add(matrix[i][rLast]);
        for (int i = rLast; i > num; --i) result.add(matrix[cLast][i]);
        for (int i = cLast; i > num; --i) result.add(matrix[i][num]);
        result.addAll(spiralOrder(matrix, num + 1));
        return result;
    }
}
