package _438_Find_All_Anagrams_in_a_String;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new LinkedList<>();
        char[] s1 = s.toCharArray(), p1 = p.toCharArray();
        int slen = s1.length, plen = p1.length;
        if(slen<plen) return result;
        HashMap<Character, Integer> countP = new HashMap<>();
        for (char i : p1)
            countP.put(i, countP.getOrDefault(i, 0) + 1);


        HashMap<Character, Integer> tmp = new HashMap<>();
        for (int i = 0; i < plen; ++i) {
            tmp.put(s1[i], tmp.getOrDefault(s1[i], 0) + 1);
        }
        boolean tmpTrue = true;
        for (Character j : tmp.keySet()) {
            if (tmp.size() != countP.size()||!(countP.containsKey(j) && countP.getOrDefault(j, 0).equals(tmp.get(j)))) {
                tmpTrue=false;
                break;
            }
        }
        if (tmpTrue) result.add(0);
        for (int i = 1; i < slen - plen + 1; ++i) {
            tmpTrue = true;
            if (tmp.get(s1[i - 1]) == 1) tmp.remove(s1[i - 1]);
            else tmp.put(s1[i - 1], tmp.get(s1[i - 1]) - 1);
            tmp.put(s1[i + plen - 1], tmp.getOrDefault(s1[i + plen - 1], 0) + 1);
            if (tmp.size() != countP.size()) continue;
            for (Character j : tmp.keySet()) {
                if (!(countP.containsKey(j) && countP.getOrDefault(j, 0).equals(tmp.get(j)))) {
                    tmpTrue = false;
                    break;
                }
            }
            if (tmpTrue) result.add(i);
        }
        return result;

        /*
        p1 = new char[countP.size()];
        int[] pCount = new int[countP.size()];
        int iP1 = 0;
        for (char i : countP.keySet()) {
            p1[iP1] = i;
            pCount[iP1] = countP.get(i);
            iP1++;
        }
        for (int i = 0; i < slen - plen + 1; ++i) {
            boolean tmp = true;
            int[] rest = Arrays.copyOf(pCount, pCount.length);
            for (int j = 0; j < plen; ++j) {
                boolean tmp2 = false;
                for (int k = 0; k < countP.size(); ++k) {
                    if (rest[k] <= 0) continue;
                    if (s1[i + j] == p1[k]) {
                        tmp2 = true;
                        --rest[k];
                        break;
                    }
                }
                if (!tmp2) {
                    tmp = false;
                    break;
                }
            }
            if (tmp) result.add(i);
        }
        return result;
        */
    }
}
