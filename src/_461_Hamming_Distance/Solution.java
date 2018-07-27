package _461_Hamming_Distance;

public class Solution {
    public int hammingDistance(int x, int y) {
        int rs = x ^ y;
        int result = 0;
        for (int i = 0; i < 31; ++i) {
            result += rs & 1;
            rs >>= 1;
        }
        return result;
    }
}
