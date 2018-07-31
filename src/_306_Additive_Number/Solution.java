package _306_Additive_Number;

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if (num.length() < 3)
            return false;
        for (int i = 1; i <= num.length() - 2; ++i) {
            if (num.charAt(0) == '0' && i != 1)
                return false;
            long first = Long.parseLong(num.substring(0, i));
            for (int j = i + 1; j <= num.length() - 1; ++j) {
                if (num.charAt(i) == '0' && j != i + 1)
                    break;
                long second = Long.parseLong(num.substring(i, j));
                long third = first + second;
                if (third != 0 && num.charAt(j) == '0')
                    continue;
                int thirdLen = String.valueOf(third).length();
                if (num.length() - j < thirdLen)
                    break;
                if (Long.parseLong(num.substring(j, j + thirdLen)) != third)
                    continue;
                if (num.length() - j == thirdLen)
                    return true;
                if (isAdditiveNumber(num.substring(i)))
                    return true;
            }
        }
        return false;
    }
}
