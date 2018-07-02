package _73_Set_Matrix_Zeroes;

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean r0 = false, c0 = false;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[i].length; ++j) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                    if (i == 0) r0 = true;
                    if (j == 0) c0 = true;
                }
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) for (int j = 1; j < matrix[i].length; ++j) matrix[i][j] = 0;
            else for (int j = 1; j < matrix[i].length; ++j) if (matrix[0][j] == 0) matrix[i][j] = 0;
        }
        if (r0) for (int j = 1; j < matrix[0].length; ++j) matrix[0][j] = 0;
        if (c0) for (int i = 1; i < matrix.length; ++i) matrix[i][0] = 0;
    }
}
