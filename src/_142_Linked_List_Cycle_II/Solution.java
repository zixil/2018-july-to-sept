package _142_Linked_List_Cycle_II;

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode p=head;
                while(true){
                    if(p==slow) return p;
                    p=p.next;
                    slow=slow.next;
                }
            }
        }
        return null;
    }
}
