import _141_Linked_List_Cycle.*;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode head=new ListNode(1);
        ListNode tail=new ListNode(2);
        head.next=tail;
        tail.next=head;
        System.out.println(new Solution().hasCycle(head));
    }
}