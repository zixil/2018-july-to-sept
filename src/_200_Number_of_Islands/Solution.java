package _200_Number_of_Islands;

public class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        if (grid.length < 1) return 0;
        for (int j = 0; j < grid[0].length; ++j) {
            if (grid[0][j] == '1' && (j == 0 || grid[0][j - 1] == '0')) {
                result++;
            }
        }
        for (int i = 1; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == '1' && (j == 0 || grid[i][j - 1] == '0') && (grid[i - 1][j] == '0')) {
                    result++;
                }
                if (grid[i][j] == '1' && (j != 0 && grid[i][j - 1] == '1' && grid[i - 1][j - 1] == '0') && (grid[i - 1][j] == '1')) {
                    result--;
                }
            }
        }
        return result;
    }
}
