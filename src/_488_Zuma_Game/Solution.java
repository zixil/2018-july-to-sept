package _488_Zuma_Game;

import java.util.Arrays;

public class Solution {

    public int findMinStep(String board, String hand) {
        int[] handCount = new int[26];
        for (char i : hand.toCharArray()) ++handCount[i - 'A'];
        board = remove(new StringBuilder(board));
        return findMinStep(board, handCount);
    }

    int findMinStep(String board, int[] handCount) {
        if (board.equals("")) return 0;
        /*
        boolean noSol=true;
        for(int i:handCount) if(i!=0){noSol=false;break;}
        */
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < board.length(); ++i) {
            //if (board.charAt(i) == board.charAt(i + 1)) {
                char tmp = board.charAt(i);
                if (handCount[tmp - 'A'] != 0) {
                    int[] newHandCount = Arrays.copyOf(handCount, 26);
                    --newHandCount[tmp - 'A'];
                    StringBuilder tmpBoard = new StringBuilder(board);
                    tmpBoard.insert(i, tmp);
                    int tmpRs = findMinStep(remove(tmpBoard), newHandCount);
                    if (tmpRs != -1) min = Math.min(min, 1 + tmpRs);
                }
            //}
        }
        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    String remove(StringBuilder s) {
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 1; i < s.length() - 1; ++i) {
                if (s.charAt(i) == s.charAt(i - 1) && s.charAt(i) == s.charAt(i + 1)) {
                    int j = 2;
                    for (; j < s.length() - i; ++j)
                        if (s.charAt(i + j) != s.charAt(i))
                            break;
                    s.delete(i - 1, i + j);
                    changed = true;
                }
            }
        }
        return s.toString();
    }
}
