package _878_Nth_Magical_Number;

public class Solution {
    public int nthMagicalNumber(int N, int A, int B) {
        int min = commonFactor(A, B);
        long a = A / min;
        long b = B / min;
        long block = a * b;
        long numBlock = a + b - 1;
        long i = 0;
        int iA = 1, iB = 1;

        for (int num = 1; num <= N % numBlock; num++) {
            if (iA * a < iB * b) {
                i = iA++ * a;
            } else {
                i = iB++ * b;
            }
        }
        return (int) (((i + N / numBlock * block) * min) % 1000000007);
    }

    int commonFactor(int a, int b) {
        return a == b ? a : commonFactor(Math.min(a, b), Math.abs(a - b));
    }
}
