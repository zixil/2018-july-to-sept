package _273_Integer_to_English_Words;

import java.util.Stack;

public class Solution {
    String[] ones = {"One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "};
    String[] tens = {"Ten ", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "};
    String[] thousands = {"", "Thousand ", "Million ", "Billion ", "Trillion "};

    public String numberToWords(int num) {
        if(num==0)
            return "Zero";
        Stack<StringBuilder> hundredNums = new Stack<>();
        while (num != 0) {
            hundredNums.push(thousand(num % 1000));
            num /= 1000;
        }
        int len = hundredNums.size();
        StringBuilder res = new StringBuilder();
        for (int i = len - 1; i >= 0; --i) {
            StringBuilder tmp = hundredNums.pop();
            if (tmp.length() == 0) continue;
            res.append(tmp.append(thousands[i]));
        }
        return res.toString().substring(0, res.length() - 1);
    }

    public StringBuilder thousand(int num) {
        StringBuilder res = new StringBuilder();
        int hundred;
        hundred = num / 100;
        num %= 100;
        if (hundred != 0)
            res.append(ones[hundred - 1]).append("Hundred ");
        if (num == 0)
            return res;
        if (num < 20)
            return res.append(ones[num - 1]);
        res.append(tens[num / 10 - 1]);
        num %= 10;
        if (num != 0)
            res.append(ones[num - 1]);
        return res;
    }
}
