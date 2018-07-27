package _657_Judge_Route_Circle;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    int[][] arrays = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
    Map<Character, int[]> map = new HashMap<>() {{
        put('U', arrays[0]);
        put('D', arrays[1]);
        put('L', arrays[2]);
        put('R', arrays[3]);
    }};
    int[] pos = {0, 0};

    public boolean judgeCircle(String moves) {
        char[] ms = moves.toCharArray();
        for (char i : ms) move(i);
        if (pos[0] == 0 && pos[1] == 0) return true;
        return false;
    }

    void move(char c) {
        int[] m = map.get(c);
        pos[0] += m[0];
        pos[1] += m[1];
    }
}
