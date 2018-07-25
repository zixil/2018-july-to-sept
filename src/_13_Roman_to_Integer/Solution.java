package _13_Roman_to_Integer;

public class Solution {
    public int romanToInt(String s) {
        int len = s.length();
        char[] c = s.toCharArray();
        int result = 0;
        for (int i = len - 1; i >= 0; --i) {
            switch (c[i]) {
                case 'I':
                    result++;
                    break;
                case 'V':
                    if (i != 0 && c[i - 1] == 'I') {
                        result += 4;
                        --i;
                    } else result += 5;
                    break;
                case 'X':
                    if (i != 0 && c[i - 1] == 'I') {
                        result += 9;
                        --i;
                    } else result += 10;
                    break;
                case 'L':
                    if(i!=0&&c[i-1]=='X'){
                        result+=40;
                        --i;
                    }else result+=50;
                    break;
                case'C':
                    if(i!=0&&c[i-1]=='X'){
                        result+=90;
                        --i;
                    }else result+=100;
                    break;
                case 'D':
                    if(i!=0&&c[i-1]=='C'){
                        result+=400;
                        --i;
                    }
                    else result+=500;
                    break;
                case 'M':
                    if(i!=0&&c[i-1]=='C'){
                        result+=900;
                        --i;
                    }else result+=1000;
                    break;
            }
        }
        return result;
    }
}
