package _647_Palindromic_Substrings;

public class Solution {
    char[] c;
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
}
