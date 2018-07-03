package _347_Top_K_Frequent_Elements;

import java.util.*;

public class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int i : nums)
            count.put(i, count.getOrDefault(i, 0) + 1);
        LinkedList<Integer>[] bucket = new LinkedList[nums.length+1];
        for (int i : count.keySet()) {
            int iCount = count.get(i);
            if (bucket[iCount] == null) bucket[iCount] = new LinkedList<>();
            bucket[iCount].add(i);
        }
        List<Integer> result=new LinkedList<>();
        int tmpK=k;
        for(int i=nums.length;i>=0;--i){
            if(bucket[i]!=null) {
                result.addAll(bucket[i]);
                tmpK-=bucket[i].size();
                if(tmpK<=0) break;
            }
        }
        return result.subList(0,k);
    }
}
