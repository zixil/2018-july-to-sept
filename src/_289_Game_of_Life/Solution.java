package _289_Game_of_Life;

import java.util.Arrays;

public class Solution {
    public void gameOfLife(int[][] board) {
        int xlen = board.length;
        if (xlen == 0) return;
        int ylen = board[0].length;
        int[][] next = new int[xlen][ylen];
        for (int i = 0; i < xlen; i++) {
            for (int j = 0; j < ylen; j++) {
                int liveNeighb = 0;
                if (i != 0) {
                    if (j != 0) liveNeighb += board[i - 1][j - 1];
                    liveNeighb += board[i - 1][j];
                    if (j != ylen - 1) liveNeighb += board[i - 1][j + 1];
                }
                if (j != 0) liveNeighb += board[i][j - 1];
                if (j != ylen - 1) liveNeighb += board[i][j + 1];
                if (i != xlen - 1) {
                    if (j != 0) liveNeighb += board[i + 1][j - 1];
                    liveNeighb += board[i + 1][j];
                    if (j != ylen - 1) liveNeighb += board[i + 1][j + 1];
                }
                if (board[i][j] == 1) {
                    if (liveNeighb < 2 || liveNeighb > 3) next[i][j] = 0;
                    else next[i][j] = 1;
                } else {
                    if (liveNeighb == 3) next[i][j] = 1;
                    else next[i][j] = 0;
                }
            }
        }
        for(int i=0;i<xlen;++i){
            board[i]=next[i];
        }
    }
}
