package _406_Queue_Reconstruction_by_Height;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {
        LinkedList<int[]> result=new LinkedList<>();
        if(people==null||people.length==0) return result.toArray(new int[result.size()][2]);
        PriorityQueue<int[]> q=new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]>o2[0]) return -1;
                if(o1[0]==o2[0]){
                    if(o1[1]<o2[1]) return -1;
                    if(o1[1]==o2[1]) return 0;
                    if(o1[1]>o2[1]) return 1;
                }
                return 1;
            }
        });
        for(int[] i:people) q.add(i);
        result.add(q.remove());
        while(!q.isEmpty()){
            int[] tmp=q.remove();
            result.add(tmp[1],tmp);
        }
        int[][] resultArray=new int[result.size()][2];
        return result.toArray(resultArray);
    }
}
