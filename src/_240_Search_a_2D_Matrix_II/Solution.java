package _240_Search_a_2D_Matrix_II;

public class Solution {
    int[][] matrix;
    int target, xlen, ylen;

    public boolean searchMatrix(int[][] matrix, int target) {
        this.xlen = matrix.length;
        if (xlen == 0) return false;
        this.ylen = matrix[0].length;
        this.matrix = matrix;
        this.target = target;
        return searchMatrix(0, 0, xlen, ylen);
    }

    boolean searchMatrix(int x1, int y1, int x2, int y2) {
        if(x1==x2||y1==y2) return false;
        if (x2 - x1 == 1) {
            for (int i : matrix[x1]) if (i == target) return true;
            return false;
        }
        if (y2 - y1 == 1) {
            for (int i = x1; i < x2; ++i) if (matrix[i][y1] == target) return true;
            return false;
        }
        int leftBound=0, rightBound=Math.min(x2 - x1,y2-y1);
        while (rightBound - leftBound > 1) {
            int i = (leftBound + rightBound) / 2;
            if (matrix[x1+i][y1+i] == target) return true;
            if (matrix[x1+i][y1+i] < target) {
                leftBound = i;
            } else if (matrix[x1+i][y1+i] > target) {
                rightBound = i;
            }
        }
        return searchMatrix(x1+rightBound,y1,x2,y1+rightBound)||searchMatrix(x1,y1+rightBound,x1+rightBound,y2);
    }
}
