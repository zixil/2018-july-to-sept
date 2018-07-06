package _200_Number_of_Islands;

public class Solution {
    char[][] g;
    int x, y;

    public int numIslands(char[][] grid) {
        if (grid.length < 1) return 0;
        g = grid;
        x = grid.length;
        y = grid[0].length;
        if (y < 1) return 0;
        int result = 0;
        for (int i = 0; i < x; ++i) {
            for (int j = 0; j < y; ++j) {
                if (g[i][j] == '1') {
                    result++;
                    setNeighbor(i, j);
                }
            }
        }
        return result;

    }

    public void setNeighbor(int i, int j) {
        g[i][j] = '0';
        if (i != 0 && g[i - 1][j] == '1') setNeighbor(i - 1, j);
        if (j != 0 && g[i][j - 1] == '1') setNeighbor(i, j - 1);
        if (i != x-1 && g[i + 1][j] == '1') setNeighbor(i + 1, j);
        if (j != y-1 && g[i][j + 1] == '1') setNeighbor(i, j + 1);
    }
}
