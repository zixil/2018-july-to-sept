package _345_Reverse_Vowels_of_a_String;

import java.util.HashSet;

public class Solution {
    char[] vowels = {'a', 'e', 'i', 'o', 'u','A','E','I','O','U'};

    public String reverseVowels(String s) {
        int len=s.length();
        char[] c=s.toCharArray();
        int[] v=new int[len];
        char[] c2=new char[len];
        int iV=0;
        for(int i=0;i<len;++i){
            if(isVowel(c[i])){
                v[iV]=i;
                ++iV;
            }
        }
        for(int jV=0;jV<iV;++jV){
            c2[jV]=c[v[iV-1-jV]];
        }
        for(int jV=0;jV<iV;++jV){
            c[v[jV]]=c2[jV];
        }
        return String.valueOf(c);
    }

    boolean isVowel(char c) {
        for (char i : vowels)
            if (i == c)
                return true;
        return false;
    }
}
