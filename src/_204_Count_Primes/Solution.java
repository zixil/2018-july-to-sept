package _204_Count_Primes;

public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        int[] num = new int[n - 2];
        int res = 0;
        for (int i = 2; i < n; ++i) {
            if (num[i - 2] == 0) {
                res++;
                for (int j = 1; j * i < n; ++j) {
                    num[i * j - 2] = -1;
                }
            }
        }
        return res;
    }
}
