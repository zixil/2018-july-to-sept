import _461_Hamming_Distance.*;

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

        int[] array1={6,85,86,38,90,21,63,38,68,18,24,54,90,82,15,61,23,87,59,27,69,68,78,28,93,35,9,94,76,86,77,43,8,17,87,64,43,10,54,35,13,19,94,75,28,32,76,43,34,100,87,29,71,14,41,28,85,77,3,25,23,69,62,91,86,99,55,16,75,70,87,63,97,4,16,54,34,16,12,94,64,2,31,76,83,27,44,29,45,7,88,62,82,40,80,49,77,71,25,21};
         System.out.println(new Solution().hammingDistance(1,4));
    }
}