package _67_Add_Binary;

public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length(), bLen = b.length(), len = Math.max(aLen, bLen);
        char[] ai = new char[len + 1], bi = new char[len + 1];
        for (int i = len - aLen + 1; i < len + 1; ++i) {
            ai[i] = (char) (a.charAt(i - (len - aLen + 1)) - '0');
        }
        for (int i = len - bLen + 1; i < len + 1; ++i) {
            bi[i] = (char) (b.charAt(i - (len - bLen + 1)) - '0');
        }
        ai[len] += bi[len];
        for (int i = len - 1; i >= 0; --i) {
            ai[i] += bi[i] + ai[i + 1] / 2;
            ai[i + 1] = (char) ((ai[i + 1] & 1) + '0');
        }
        if (ai[0] == 0)
            return String.valueOf(ai, 1, len);
        else {
            ai[0] += '0';
            return String.valueOf(ai);
        }
    }
}
