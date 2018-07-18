package _43_Multiply_Strings;

import java.util.Arrays;

public class Solution {
    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray(), n2 = num2.toCharArray();
        char[] result = {0};
        for (int i = 0; i < n1.length; ++i) n1[i] -= '0';
        for (int i = 0; i < n2.length; ++i) {
            n2[n2.length-1-i] -= '0';
            result = add(result, multiply(n1, n2[n2.length-1-i]), i);
        }
        for (int i = 0; i < result.length; ++i) {
            result[i] += '0';
        }
        return String.valueOf(result);
    }

    public char[] multiply(char[] num1, char num2) {
        char[] result = new char[num1.length + 1];
        for (int i = 0; i < num1.length; ++i)
            result[i+1] = (char) (num1[i] * num2);
        for (int i = result.length - 1; i >= 1; --i) {
            result[i - 1] += result[i] / 10;
            result[i]%=10;
        }
        return result;
    }

    public char[] add(char[] num1, char[] num2, int multiply10) {
        char[] result;
        if (num1.length >= num2.length + multiply10) {
            result = new char[num1.length + 1];
            for (int i = 0; i < multiply10; ++i) {
                result[result.length - 1 - i] = num1[num1.length - 1 - i];
            }
            for (int i = multiply10; i < num2.length + multiply10; ++i) {
                result[result.length - 1 - i] = (char) (num1[num1.length - 1 - i] + num2[num2.length - 1 - i + multiply10]);
            }
            for (int i = num2.length + multiply10 + multiply10; i < num1.length; ++i) {
                result[result.length - 1 - i] = num1[num1.length - 1 - i];
            }
        } else {
            result = new char[num2.length + multiply10 + 1];
            if (num1.length >= multiply10) {
                for (int i = 0; i < multiply10; ++i) {
                    result[result.length - 1 - i] = num1[num1.length - 1 - i];
                }
                for (int i = multiply10; i < num1.length; ++i) {
                    result[result.length - 1 - i] = (char) (num1[num1.length - 1 - i] + num2[num2.length - 1 - i + multiply10]);
                }
                for (int i = num1.length; i < num2.length + multiply10; ++i) {
                    result[result.length - 1 - i] = num2[num2.length - 1 - i + multiply10];
                }
            } else {
                for (int i = 0; i < num1.length; ++i) {
                    result[result.length - 1 - i] = num1[num1.length - 1 - i];
                }
                for (int i = num1.length; i < multiply10; ++i) {
                    result[result.length - 1 - i] = 0;
                }
                for (int i = multiply10; i < num2.length + multiply10; ++i) {
                    result[result.length - 1 - i] = num2[num2.length - 1 - i + multiply10];
                }
            }
        }
        for (int i = result.length - 1; i >= 1; --i) {
            result[i - 1] += result[i] / 10;
            result[i]%=10;
        }
        for (int i = 0; i < result.length; ++i) {
            if (result[i] != 0) return Arrays.copyOfRange(result, i, result.length);
        }
        char[] array = {0};
        return array;
    }
}
