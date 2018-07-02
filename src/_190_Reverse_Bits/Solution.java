package _190_Reverse_Bits;

public class Solution {
    public int reverseBits(int n) {
        int tmp = 0;
        for (int i = 0; i < 32; ++i) {
            tmp |= (n & 1) << (31 - i);
            n >>= 1;
        }
        return tmp;
    }
}