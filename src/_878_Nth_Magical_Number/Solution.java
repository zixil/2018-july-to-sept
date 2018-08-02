package _878_Nth_Magical_Number;

public class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int min = commonFactor(A, B);
        long a = A / min;
        long b = B / min;
        long i = Math.min(a, b);
        for (int num = 0; num < N; i++) {
            if (i % b == 0 || i % a == 0) num++;
        }
        return (int) (((i - 1) * min) % 1000000007);
    }

    int commonFactor(int a, int b) {
        return a == b ? a : commonFactor(Math.min(a, b), Math.abs(a - b));
    }
}
