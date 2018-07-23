package _542_01_Matrix;

public class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int xlen = matrix.length;
        int ylen = matrix[0].length;
        int[][] dis = new int[xlen][ylen];
        int size = xlen * ylen;
        for (int i = 0; i < xlen; ++i) {
            for (int j = 0; j < ylen; ++j) {
                dis[i][j] = (matrix[i][j] == 0 ? 0 : -1);
            }
        }

        int tmpSize;
        int cur = 0;
        do {
            tmpSize = size;
            for (int i = 0; i < xlen; ++i) {
                for (int j = 0; j < ylen; ++j) {
                    if (dis[i][j] != -1) continue;
                    if (i != 0 && dis[i - 1][j] == cur
                            || j != 0 && dis[i][j - 1] == cur
                            || i != xlen - 1 && dis[i + 1][j] == cur
                            || j != ylen - 1 && dis[i][j + 1] != -1)
                        dis[i][j] = cur + 1;
                    else tmpSize--;
                }
            }
            cur++;
        } while (tmpSize != size);
        return dis;
    }
}
