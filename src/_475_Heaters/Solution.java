package _475_Heaters;

public class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        int dist = Math.max(heaters[0] - houses[0], houses[houses.length - 1] - heaters[heaters.length - 1]);
        for (int i = 1; i < heaters.length; ++i) {
            dist = Math.max(dist, (heaters[i] - heaters[i - 1] + 1) / 2);
        }
        return dist;
    }

}
