package _8_String_to_Integer_atoi;

public class Solution {
    public int myAtoi(String str) {
        char[] s = str.toCharArray();
        int begin = 0;
        int end = s.length;
        for (; begin < end; ++begin)
            if (s[begin] != ' ') break;
        if (begin == end) return 0;

        int positive = 1;
        long result = 0;
        if (s[begin] == '-') {
            positive = -1;
            ++begin;
        } else if (s[begin] == '+') ++begin;

        for(int i=begin;i<end&&s[i]=='0';++i){
            ++begin;
        }
        for (int i = begin; i < end; ++i) {
            if (s[i] < '0' || s[i] > '9') {
                end = i;
                break;
            }
        }
        if(end-begin>10){
            if(positive==1) return Integer.MAX_VALUE;
            if(positive==-1) return Integer.MIN_VALUE;
        }
        long tens = 1;
        for (int i = end - 1; i >= begin; --i, tens *= 10)
            result += (s[i]-'0') * tens;
        result *= positive;
        if(result>Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(result<Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)result;
    }
}
