package _338_Counting_Bits;

public class Solution {
    public int[] countBits(int num) {
        int[] tmp = new int[num + 1];
        tmp[0] = 0;
        int x = 0;
        for (int i = 1; i <= num; i <<= 1) {
            for (int j = 0; j < i; ++j) {
                if (i + j <= num)
                    tmp[i + j] = tmp[j] + 1;
                else return tmp;
            }
        }
        return tmp;
    }
}
