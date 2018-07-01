package _119_Pascal_s_Triangle_II;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> preList=new LinkedList<>();
        preList.add(1);
        for(int i=1;i<=rowIndex;++i){
            List<Integer> curList=new LinkedList<>();
            curList.add(1);
            Iterator<Integer> iPre = preList.iterator();
            int prePre=iPre.next();
            while(iPre.hasNext()){
                int curPre=iPre.next();
                curList.add(curPre+prePre);
                prePre=curPre;
            }
            curList.add(1);
            preList=curList;
        }
        return preList;
    }
}
