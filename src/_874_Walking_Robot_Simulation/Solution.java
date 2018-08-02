package _874_Walking_Robot_Simulation;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    int[] pos = {0, 0};
    int dir = 0;
    int[][] move = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int dist = 0;

    public int robotSim(int[] commands, int[][] obstacles) {
        getMap(obstacles);
        for (int i : commands)
            conductCommand(i);
        return dist;
    }

    public boolean isObstacle(int[] pos) {
        HashSet<Integer> tmpSet = map.get(pos[0]);
        if (tmpSet == null) return false;
        return tmpSet.contains(pos[1]);
    }

    public void getMap(int[][] obstacles) {
        for (int[] i : obstacles) {
            HashSet<Integer> tmpSet = map.getOrDefault(i[0], new HashSet<>());
            tmpSet.add(i[1]);
            map.put(i[0], tmpSet);
        }
    }

    public void conductCommand(int command) {
        if (command == -1) {
            dir = (dir + 1) % 4;
        } else if (command == -2) {
            dir = (dir + 3) % 4;
        } else if (command == 1) {
            int[] newPos = Arrays.copyOf(pos, 2);
            newPos[0] += move[dir][0];
            newPos[1] += move[dir][1];
            if (!isObstacle(newPos)) {
                pos = newPos;
                dist = Math.max(dist, pos[0] * pos[0] + pos[1] * pos[1]);
            }
        } else {
            for (int i = 0; i < command; ++i) conductCommand(1);
        }
    }
}
