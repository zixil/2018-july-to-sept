package _85_Maximal_Rectangle;

public class Solution {
    char[][] matrix;
    int xLen, yLen;

    public int maximalRectangle(char[][] matrix) {
        xLen = matrix.length;
        if (xLen == 0)
            return 0;
        yLen = matrix[0].length;
        this.matrix = matrix;
        int maxArea = 0;

        for (int i = xLen; i >= 1; --i) {
            int minY = 1, maxY = yLen;
            if (findArea(i, maxY)) {
                maxArea = Math.max(maxArea, i * maxY);
                continue;
            }
            if (!findArea(i, minY)) continue;
            while (maxY - minY > 1) {
                int midY = (minY + maxY) / 2;
                boolean findMid = findArea(i, midY);
                if (findMid) minY = midY;
                else maxY = midY;
            }
            maxArea = Math.max(maxArea, i * minY);
        }
        return maxArea;
    }

    boolean findArea(int xLen, int yLen) {
        for (int i = 0; i <= this.xLen - xLen; ++i) {
            second:
            for (int j = 0; j <= this.yLen - yLen; ++j) {
                for (int x = 0; x < xLen; ++x) {
                    for (int y = 0; y < yLen; ++y) {
                        if (matrix[i + x][j + y] == '0') {
                            j += y;
                            continue second;
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }
}
