package _460_LFU_Cache;

import java.util.HashMap;
import java.util.LinkedHashSet;


class LFUCache {
    //{key:[val,count]}
    HashMap<Integer, int[]> countsNVals = new HashMap<>();
    //{count:[key]}
    HashMap<Integer, LinkedHashSet<Integer>> map = new HashMap<>();
    int capacity;
    int size = 0;
    int min = -1;

    public LFUCache(int capacity) {
        this.capacity = capacity;
        map.put(1, new LinkedHashSet<>());
    }

    public int get(int key) {
        if (!countsNVals.containsKey(key))
            return -1;
        int[] countNVal = countsNVals.get(key);
        int count = countNVal[1];
        map.get(count).remove(key);
        if (count == min && map.get(count).size() == 0)
            min++;
        countNVal[1] = ++count;
        if (!map.containsKey(count))
            map.put(count, new LinkedHashSet<>());
        map.get(count).add(key);
        return countNVal[0];
    }

    public void put(int key, int value) {
        if (capacity <= 0)
            return;
        if (countsNVals.containsKey(key)) {
            countsNVals.get(key)[0] = value;
            get(key);
            return;
        }
        if (size == capacity) {
            LinkedHashSet<Integer> minList = map.get(min);
            int minKey = minList.iterator().next();
            minList.remove(minList.iterator().next());
            countsNVals.remove(minKey);
            --size;
        }
        int[] array = {value, 1};
        countsNVals.put(key, array);
        map.get(1).add(key);
        min = 1;
        ++size;
    }
}
