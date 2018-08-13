package _526_Beautiful_Arrangement;

public class Solution {
    int N;
    boolean[][] able;
    boolean[] numUsed;

    public int countArrangement(int N) {
        this.N = N;
        able = new boolean[N + 1][N + 1];
        numUsed = new boolean[N + 1];
        for (int i = 1; i <= N; ++i) {
            for (int j = i; j <= N; j += i) {
                able[i][j] = able[j][i] = true;
            }
        }
        return count(1);
    }

    int count(int start) {
        if (start == N + 1) return 1;
        int res = 0;
        for (int j = 1; j <= N; ++j) {
            if (able[start][j] && !numUsed[j]) {
                numUsed[j] = true;
                res += count(start + 1);
                numUsed[j] = false;
            }
        }
        return res;
    }

}
