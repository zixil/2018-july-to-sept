package _875_Koko_Eating_Bananas;

public class Solution {
    int[] piles;

    public int minEatingSpeed(int[] piles, int H) {
        this.piles = piles;
        long total = 0;
        long max = 0;
        for (int i : piles) {
            total += i;
            max = Math.max(max, i);
        }
        long min = ((total + H - 1) / H);
        long hourMin = hourNeeded(min);
        while (hourMin > H) {
            if (max - min == 1) {
                min = max;
                hourMin = hourNeeded(min);
            } else {
                long mid = (max + min) / 2;
                long hourMid = hourNeeded(mid);
                if (hourMid <= H) max = mid;
                else {
                    min = mid;
                    hourMin = hourMid;
                }
            }
        }
        return (int) min;
    }

    long hourNeeded(long k) {
        long res = 0;
        for (int i : piles)
            res += (i + k - 1) / k;
        return res;
    }
}

