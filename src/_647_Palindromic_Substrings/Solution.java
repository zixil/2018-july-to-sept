package _647_Palindromic_Substrings;

public class Solution {
    /*
    public int countSubstrings(String s) {
        c=s.toCharArray();
        int len=c.length;
        int res=len;
        for(int i=0;i<len;++i){
            for(int j=i+2;j<=len;++j){
                if(isPalindromic(i,j)) res++;
            }
        }
        return res;
    }
    public boolean isPalindromic(int start, int end){
        for(int i=0;i<end-start;++i){
            if(c[start+i]!=c[end-1-i]) return false;
        }
        return true;
    }
    */

    public int countSubstrings(String s) {
        char[] c = new char[2 * s.length() + 3];
        c[0] = '$';
        c[1] = '#';
        c[c.length - 1] = '%';
        for (int i = 0; i < s.length(); ++i) {
            c[i * 2 + 2] = s.charAt(i);
            c[i * 2 + 3] = '#';
        }
        int len = c.length;
        int id = 0, mx = 0, palindromic[] = new int[len];
        for (int i = 0; i < len; ++i) {
            int r = i < mx ? Math.min(palindromic[2 * id - i], mx - i) : 1;
            for (; r < len - i && r <= 2 * i; ++r) {
                if (c[i + r] != c[i - r]) break;
            }
            palindromic[i] = r - 1;
            if (i + r - 1 > mx) {
                mx = i + r - 1;
                id = i;
            }
        }
        int sum = 0;
        for (int i = 1; i < len; ++i) {
            sum += (palindromic[i] + 1) / 2;
        }
        return sum;
    }
}
