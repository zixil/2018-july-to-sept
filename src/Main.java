import _400_Nth_Digit.*;

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

        int[] array1={90,100,50,70,20,40,10,51};
         System.out.println(new Solution().findNthDigit(2147483647));
    }
}