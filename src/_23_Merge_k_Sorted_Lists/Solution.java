package _23_Merge_k_Sorted_Lists;

public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode[] tails = new ListNode[lists.length];
        for (int i = 0; i < lists.length; ++i) tails[i] = lists[i];
        while (true) {
            boolean canBreak = true;
            int min = Integer.MAX_VALUE;
            int minI=0;
            for (int i = 0; i < tails.length; ++i) {
                if (tails[i] != null) {
                    canBreak = false;
                    if (tails[i].val < min) {
                        minI = i;
                        min=tails[i].val;
                    }
                }
            }
            if (canBreak) break;
            tail.next=new ListNode(min);
            tail=tail.next;
            tails[minI]=tails[minI].next;
        }
        return head.next;
    }
}
