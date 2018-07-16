import _310_Minimum_Height_Trees.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        int[] array={-1,-7,7,-4,19,6,-9,-5,-2,-5};
        ListNode head=new ListNode(0);
        ListNode tail=head;
        for(int i:array){
            tail.next=new ListNode(i);
            tail=tail.next;
        }
        ListNode tmp=head;
        for(int i=0;i<6;++i) {
            tmp=tmp.next;
        }
        tail.next = tmp;
        */
        int[] array={};
         System.out.println(new Solution().findMinHeightTrees(5000, array));
    }
}