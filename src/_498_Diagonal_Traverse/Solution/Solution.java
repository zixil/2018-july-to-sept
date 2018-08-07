package _498_Diagonal_Traverse.Solution;

public class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
        int xLen = matrix.length;
        if (xLen == 0) return new int[0];
        int yLen = matrix[0].length;
        int[] res = new int[xLen * yLen];
        int resI = 0;
        for (int i = 0; i < xLen + yLen; ++i) {
            if ((i & 1) == 0) {
                for (int j = Math.max(i - xLen + 1, 0); j < yLen && j <= i; ++j)
                    res[resI++] = matrix[i - j][j];
            } else {
                for (int j = Math.max(i - yLen + 1, 0); j < xLen && j <= i; ++j)
                    res[resI++] = matrix[j][i - j];
            }
        }
        return res;
    }
}
