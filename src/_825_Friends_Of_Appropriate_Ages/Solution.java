package _825_Friends_Of_Appropriate_Ages;

import java.util.Arrays;

public class Solution {

    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        int[] friend = new int[121];
        for (int i : ages) ++count[i];
        for (int i = 1; i <= 120; ++i) {
            if (count[i] == 0) continue;
            for (int j = i / 2 + 7 + 1; j <= Math.min(i, 121); ++j) {
                friend[i] += i == j ? count[i] * (count[i] - 1) : count[j] * count[i];
            }
        }
        return Arrays.stream(friend).sum();
    }
}
