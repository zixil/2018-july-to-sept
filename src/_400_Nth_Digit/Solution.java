package _400_Nth_Digit;

public class Solution {
    public int findNthDigit(int n) {
        int numLen = 1;
        long lenCountBy9 = 1;
        while (n >= lenCountBy9 * numLen * 9) {
            n -= lenCountBy9 * numLen * 9;
            numLen++;
            lenCountBy9 *= 10;
        }
        int num = n / numLen;
        int i = n % numLen;
        num += lenCountBy9;
        return String.valueOf(num).charAt(i) - '0';
    }
}
