package _401_Binary_Watch;

import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> res = new LinkedList<>();
        for (int h = 0; h < 12; ++h) {
            for (int m = 0; m < 60; ++m) {
                if (Integer.bitCount((h << 6) + m) == num)
                    res.add(String.valueOf(h) + (m < 10 ? ":0" : ":") + String.valueOf(m));
            }
        }
        return res;
    }
}
