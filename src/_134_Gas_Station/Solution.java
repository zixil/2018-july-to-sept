package _134_Gas_Station;

public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int len = gas.length;
        for (int i = 0; i < len; ++i) {
            boolean success = true;
            int tank = 0;
            for (int j = 0; j < gas.length; ++j) {
                int tmpPlace = i + j;
                if (tmpPlace >= len) tmpPlace -= len;
                tank += gas[tmpPlace] - cost[tmpPlace];
                if (tank < 0) {
                    success = false;
                    break;
                }
            }
            if (success) return i;
        }
        return -1;
    }
}
