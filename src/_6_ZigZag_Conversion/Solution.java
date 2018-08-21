package _6_ZigZag_Conversion;

public class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1) return s;
        char[] c = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (int col = 0; col * (numRows - 1) < c.length; col += 2) {
            builder.append(c[col * (numRows - 1)]);
        }
        for (int row = 1; row < numRows - 1; ++row) {
            for (int col = 0; ; col += 2) {
                if (col * (numRows - 1) + row >= c.length) break;
                builder.append(c[col * (numRows - 1) + row]);
                if ((col + 2) * (numRows - 1) - row >= c.length) break;
                builder.append(c[(col + 2) * (numRows - 1) - row]);
            }
        }
        for (int col = 0; (col + 1) * (numRows - 1) < c.length; col += 2) {
            builder.append(c[(col + 1) * (numRows - 1)]);
        }
        return builder.toString();
    }
}
