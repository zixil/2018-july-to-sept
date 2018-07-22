package _260_Single_Number_III;

public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) diff ^= i;
        diff &= -diff;
        int[] result = {0, 0};
        for (int i : nums) result[(i & diff) == 0 ? 0 : 1] ^= i;
        return result;
    }
}
