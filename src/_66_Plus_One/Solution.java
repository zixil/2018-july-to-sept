package _66_Plus_One;

public class Solution {
    public int[] plusOne(int[] digits) {
        return plusOne(digits, digits.length);
    }

    public int[] plusOne(int[] digits, int end) {
        if (digits[end - 1] == 9) {
            digits[end - 1] = 0;
            if (end == 1) {
                int[] result = new int[digits.length + 1];
                result[0] = 1;
                for (int i = 1; i < digits.length + 1; ++i)
                    result[i] = digits[i - 1];
                return result;
            } else {
                return plusOne(digits, end - 1);
            }
        } else digits[end - 1]++;
        return digits;
    }
}
