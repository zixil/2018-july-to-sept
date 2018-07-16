package _316_Remove_Duplicate_Letters;

import java.util.HashMap;

public class Solution {
    HashMap<Character, int[]> map;
    char[] ca;

    public String removeDuplicateLetters(String s) {
        if (s == null || s.equals("")) return "";
        StringBuilder builder = new StringBuilder();
        //LinkedList<Character> list = new LinkedList<>();
        ca = s.toCharArray();
        map = getMap(0);
        int premin = 0;
        int min = minLast(0);
        do {
            if (map.size() == 0) break;
            premin = getIMinChar(premin, min);
            builder.append(ca[premin]);
            map.remove(ca[premin]);
            min = minLast(min);
            premin++;
        } while (premin <= min);

        return builder.toString();
    }

    public int minLast(int start) {
        int min = ca.length - 1;
        for (Character i : map.keySet()) {
            int tmp = map.get(i)[1];
            if (min >= tmp && tmp >= start)
                min = tmp;
        }
        return min;
    }

    public HashMap<Character, int[]> getMap(int start) {
        HashMap<Character, int[]> tmpMap = new HashMap<>();
        for (int i = start; i < ca.length; ++i) {
            char tmp = ca[i];
            int[] array = {1, i};
            if (tmpMap.containsKey(tmp))
                array[0] = tmpMap.get(tmp)[0] + 1;
            tmpMap.put(tmp, array);
        }
        return tmpMap;
    }

    public int getIMinChar(int start, int min) {
        int iMinChar = min;
        for (int i = start; i < min; ++i) {
            if (map.containsKey(ca[i]) && (ca[i] < ca[iMinChar] || ca[i] == ca[iMinChar] && i < iMinChar)) {
                iMinChar = i;
            }
        }
        return iMinChar;
    }
}
