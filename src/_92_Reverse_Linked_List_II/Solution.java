package _92_Reverse_Linked_List_II;

import DataStructures.ListNode;

public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode preHead = new ListNode(0);
        preHead.next=head;
        ListNode pre=preHead;
        for (int i = 1; i < m; ++i) pre = pre.next;
        ListNode tmpHead = pre.next;
        ListNode postTail = tmpHead;
        for (int i = m; i <= n; ++i) postTail = postTail.next;
        for (int i = 0; i < n - m+1; ++i) {
            ListNode newTmpHead = tmpHead.next;
            tmpHead.next = postTail;
            postTail = tmpHead;
            tmpHead = newTmpHead;
        }
        pre.next = postTail;
        return preHead.next;
    }
}
