package _556_Next_Greater_Element_III;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    String nStr;
    char[] nCh;
    int[] count = new int[10];

    public int nextGreaterElement(int n) {
        count = new int[10];
        nStr = String.valueOf(n);
        nCh = nStr.toCharArray();
        if (nCh.length == 10) {
            if (nCh[0] == '2') {
                int next = nextGreaterElement(n - 2000000000);
                return next == -1 || next > 147483647 ? -1 : 2000000000 + next;
            }
            for (char i : nCh)
                ++count[i - '0'];
            if (count[2] == 0) {
                int next = nextGreaterElement(n - 1000000000);
                return next == -1 ? -1 : 1000000000 + next;
            }
            --count[2];
            int next = 0;
            for (int i = 0; i <= 9; ++i) {
                for (int j = 0; j < count[i]; ++j) {
                    next = next * 10 + i;
                }
            }
            return next > 147483647 ? -1 : 2000000000 + next;
        }
        int changeDigit = getChangeDigit();
        if (changeDigit == -1)
            return -1;
        StringBuilder res = new StringBuilder(nStr.substring(0, changeDigit));
        for (int i = 0; i < changeDigit; ++i) {
            --count[nCh[i] - '0'];
        }
        for (int i = nCh[changeDigit] - '0' + 1; i <= 9; ++i) {
            if (count[i] != 0) {
                res.append(i);
                --count[i];
                break;
            }
        }
        for (int i = 0; i <= 9; ++i) {
            for (int j = 0; j < count[i]; ++j) {
                res.append(i);
            }
        }
        return Integer.parseInt(res.toString());
    }

    int getChangeDigit() {
        for (char i : nCh)
            ++count[i - '0'];
        int[] tmpCount = Arrays.copyOf(count, 10);
        int maxDigit = 0;
        for (int i = 9; i >= 0; --i) {
            if (count[i] != 0) {
                maxDigit = i;
                break;
            }
        }
        int res = -1;
        for (int i = 0; i < nCh.length; ++i) {
            if (nCh[i] != maxDigit + '0')
                res = i;
            --tmpCount[nCh[i] - '0'];
            if (tmpCount[maxDigit] == 0) {
                for (int j = maxDigit; j >= 0; --j) {
                    if (tmpCount[j] != 0) {
                        maxDigit = j;
                        break;
                    }
                }
            }
        }
        return res;
    }
}
