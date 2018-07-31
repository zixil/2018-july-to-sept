import _274_H_Index.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        int[] array={1,2,3,4,5};
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
        tail.next = tmp;*/

        int[] array1={2,2,2,4,4,4};
         System.out.println(new Solution().hIndex(array1));
    }
}