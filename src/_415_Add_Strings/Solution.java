package _415_Add_Strings;

import java.util.Arrays;
import java.util.stream.IntStream;

public class Solution {
    public String addStrings(String num1, String num2) {
        char[] c1 = num1.toCharArray(), c2 = num2.toCharArray();
        if (c1.length < c2.length) {
            char[] tmp = c1;
            c1 = c2;
            c2 = tmp;
        }
        int difLen = c1.length - c2.length;
        char[] c3 = new char[c1.length + 1];
        for (int i = c1.length - 1; i >= difLen; --i) {
            c3[i + 1] += (char) (c1[i] + c2[i - difLen] - '0' - '0');
            c3[i] += c3[i + 1] / 10;
            c3[i + 1] = (char) (c3[i + 1] % 10 + '0');
        }
        for (int i = difLen - 1; i >= 0; --i) {
            c3[i + 1] += (char) (c1[i] - '0');
            c3[i] += c3[i + 1] / 10;
            c3[i + 1] = (char) (c3[i + 1] % 10 + '0');
        }
        c3[0] += '0';
        if (c3[0] == '0') {
            int i = 0;
            for (; i < c3.length - 1 && c3[i] == '0'; ++i) ;
            return String.valueOf(c3, i, c3.length - i);
        }
        return String.valueOf(c3);
    }
}
